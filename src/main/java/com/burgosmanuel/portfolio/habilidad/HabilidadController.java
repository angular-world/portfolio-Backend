package com.burgosmanuel.portfolio.habilidad;

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

@CrossOrigin
@RestController
@RequestMapping("/habilidades")
public class HabilidadController {

    @Autowired
    HabilidadService service;

    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public void agregarHabilidad(@RequestBody Habilidad hab) {
        service.agregarHabilidad(hab);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editarHabilidad(@PathVariable Long id, @RequestBody Habilidad datosHabilidad) {
        service.editarHabilidad(id, datosHabilidad);
    }

    @GetMapping("/{id}")
    public Habilidad buscarHabilidad(@PathVariable Long id) {
        return service.buscarHabilidad(id);
    }

    @GetMapping("/listar")
    public List<Habilidad> listarHabilidades() {
        return service.listarHabilidades();
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void borrarHabilidad(@PathVariable Long id) {
        service.borrarHabilidad(id);
    }
}
