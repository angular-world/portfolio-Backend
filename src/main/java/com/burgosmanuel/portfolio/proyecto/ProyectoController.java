package com.burgosmanuel.portfolio.proyecto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProyectoController {

    @Autowired
    ProyectoService service;

    @PostMapping("/proyectos/agregar")
    public void agregarProyecto(@RequestBody Proyecto proj) {
        service.agregarProyecto(proj);
    }

    @PutMapping("/proyectos/editar/{id}")
    public void editarProyecto(@PathVariable int id, @RequestBody Proyecto datosProyecto) {
        service.editarProyecto(id, datosProyecto);
    }

    @GetMapping("/proyectos/{id}")
    public Proyecto buscarProyecto(@PathVariable int id) {
        return service.buscarProyecto(id);
    }

    @GetMapping("/proyectos")
    public List<Proyecto> listarProyectos() {
        return service.listarProyectos();
    }

    @DeleteMapping("/proyectos/eliminar/{id}")
    public void borrarProyecto(@PathVariable int id) {
        service.borrarProyecto(id);
    }
}
