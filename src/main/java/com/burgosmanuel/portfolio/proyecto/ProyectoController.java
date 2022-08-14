package com.burgosmanuel.portfolio.proyecto;

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
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    ProyectoService service;

    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public void agregarProyecto(@RequestBody ProyectoDTO proj) {
        service.agregarProyecto(proj);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO datosProyecto) {
        service.editarProyecto(id, datosProyecto);
    }

    @GetMapping("/{id}")
    public ProyectoDTO buscarProyecto(@PathVariable Long id) {
        return service.buscarProyecto(id);
    }

    @GetMapping("/listar")
    public List<ProyectoDTO> listarProyectos() {
        return service.listarProyectos();
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void borrarProyecto(@PathVariable Long id) {
        service.borrarProyecto(id);
    }
}
