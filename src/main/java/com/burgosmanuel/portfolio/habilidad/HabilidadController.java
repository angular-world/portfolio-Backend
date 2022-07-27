package com.burgosmanuel.portfolio.habilidad;

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
public class HabilidadController {

    @Autowired
    HabilidadService service;

    @PostMapping("/habilidades/agregar")
    public void agregarHabilidad(@RequestBody Habilidad hab) {
        service.agregarHabilidad(hab);
    }

    @PutMapping("/habilidades/editar/{id}")
    public void editarHabilidad(@PathVariable int id, @RequestBody Habilidad datosHabilidad) {
        service.editarHabilidad(id, datosHabilidad);
    }

    @GetMapping("/habilidades/{id}")
    public Habilidad buscarHabilidad(@PathVariable int id) {
        return service.buscarHabilidad(id);
    }

    @GetMapping("/habilidades")
    public List<Habilidad> listarHabilidades() {
        return service.listarHabilidades();
    }

    @DeleteMapping("/habilidades/eliminar/{id}")
    public void borrarHabilidad(@PathVariable int id) {
        service.borrarHabilidad(id);
    }
}
