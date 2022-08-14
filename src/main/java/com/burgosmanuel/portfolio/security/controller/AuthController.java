package com.burgosmanuel.portfolio.security.controller;

import com.burgosmanuel.portfolio.educacion.EducacionService;
import com.burgosmanuel.portfolio.experiencia.ExperienciaService;
import com.burgosmanuel.portfolio.habilidad.HabilidadService;
import com.burgosmanuel.portfolio.persona.Persona;
import com.burgosmanuel.portfolio.persona.PersonaService;
import com.burgosmanuel.portfolio.proyecto.ProyectoService;
import com.burgosmanuel.portfolio.seccion.SeccionService;
import com.burgosmanuel.portfolio.security.entity.ERole;
import com.burgosmanuel.portfolio.security.entity.Role;
import com.burgosmanuel.portfolio.security.entity.User;
import com.burgosmanuel.portfolio.security.jwt.JwtUtils;
import com.burgosmanuel.portfolio.security.payload.JwtResponse;
import com.burgosmanuel.portfolio.security.payload.LoginRequest;
import com.burgosmanuel.portfolio.security.payload.MessageResponse;
import com.burgosmanuel.portfolio.security.payload.RegisterRequest;
import com.burgosmanuel.portfolio.security.repository.RoleRepository;
import com.burgosmanuel.portfolio.security.repository.UserRepository;
import com.burgosmanuel.portfolio.security.service.UserDetailsImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SeccionService seccionService;
    @Autowired
    PersonaService personaService;
    @Autowired
    EducacionService educacionService;
    @Autowired
    ExperienciaService experienciaService;
    @Autowired
    HabilidadService habilidadService;
    @Autowired
    ProyectoService proyectoService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: ¡Este nombre de usuario ya fue utilizado!"));
        }
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: ¡Este e-mail ya fue utilizado!"));
        }

        // Creamos un nuevo usuario
        User user = new User(registerRequest.getUsername(), registerRequest.getEmail(), encoder.encode(registerRequest.getPassword()));
        Set<String> strRoles = registerRequest.getRole();
        Set<Role> roles = new HashSet();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: No se encontró el rol especificado."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "user":
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: No se encontró el rol especificado."));
                        roles.add(userRole);
                        break;
                    default:
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: No se encontró el rol especificado."));
                        roles.add(adminRole);

                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        // Creamos una nueva entrada en "Persona" cuando nos registramos, a modo de placeholder. TODO: Enlazar las demas tablas a persona y modificar la ID en el front.
        Persona nuevaPersona = new Persona(user, "Nombre y Apellido", "Titulo", "https://www.linkedin.com", "https://github.com", "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png", "https://cabaretfestival.es/wp-content/uploads/2020/07/Hero-Banner-Placeholder-Light-1024x480-1.png", "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png");
        personaService.crearPersona(nuevaPersona);
        seccionService.crearSeccionesDefault(user.getId());
        educacionService.crearEducacionDefault(user.getId());
        experienciaService.crearExperienciaDefault(user.getId());
        habilidadService.crearHabilidadDefault(user.getId());
        proyectoService.crearProyectoDefault(user.getId());
        
        return ResponseEntity.ok(new MessageResponse("¡El usuario se registró con éxito!"));
    }
}
