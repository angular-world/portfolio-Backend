package com.burgosmanuel.portfolio.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    PersonaService service;

    @GetMapping("/{id}")
    public Persona buscarPersona(@PathVariable Long id) {
        return service.buscarPersona(id);
    }

    @PostMapping("/crear")
        @PreAuthorize("hasRole('ADMIN')")
    public void crearPersona(@RequestBody Persona pers) {
        service.crearPersona(pers);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editarPersona(@PathVariable Long id, @RequestBody Persona datosPersona) {
        service.editarPersona(id, datosPersona);
    }
}
