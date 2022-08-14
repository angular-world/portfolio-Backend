package com.burgosmanuel.portfolio.educacion;

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
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    EducacionService service;

    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public void agregarEducacion(@RequestBody EducacionDTO edu) {
        service.agregarEducacion(edu);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editarEducacion(@PathVariable Long id, @RequestBody EducacionDTO datosEducacion) {
        service.editarEducacion(id, datosEducacion);
    }

    @GetMapping("/listar")
    public List<EducacionDTO> listarEducacion() {
        return service.listarEducacion();
    }

    @GetMapping("/{id}")
    public EducacionDTO buscarEducacion(@PathVariable Long id) {
        return service.buscarEducacion(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void borrarEducacion(@PathVariable Long id) {
        service.borrarEducacion(id);
    }
}
