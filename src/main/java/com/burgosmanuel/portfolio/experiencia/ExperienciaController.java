package com.burgosmanuel.portfolio.experiencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    ExperienciaService service;

    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public void agregarExperiencia(@RequestBody Experiencia exp) {
        service.agregarExperiencia(exp);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editarExperiencia(@PathVariable Long id, @RequestBody Experiencia datosExperiencia) {
        service.editarExperiencia(id, datosExperiencia);
    }

    @GetMapping("/listar")
    public List<Experiencia> listarExperiencia() {
        return service.listarExperiencia();
    }

    @GetMapping("/{id}")
    public Experiencia buscarExperiencia(@PathVariable Long id) {
        return service.buscarExperiencia(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void borrarExperiencia(@PathVariable Long id) {
        service.borrarExperiencia(id);
    }
}
