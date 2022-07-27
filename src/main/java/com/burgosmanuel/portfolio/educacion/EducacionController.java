package com.burgosmanuel.portfolio.educacion;

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
public class EducacionController {
    
    @Autowired
    EducacionService service;
    
    @PostMapping("/educacion/agregar")
    public void agregarEducacion(@RequestBody Educacion edu) {
        service.agregarEducacion(edu);
    }
    
    @PutMapping("/educacion/editar/{id}")
    public void editarEducacion(@PathVariable int id, @RequestBody Educacion datosEducacion) {
        service.editarEducacion(id, datosEducacion);
    }
    
    @GetMapping("/educacion")
    public List<Educacion> listarEducacion() {
        return service.listarEducacion();
    }
    
    @GetMapping("/educacion/{id}")
    public Educacion buscarEducacion(@PathVariable int id) {
        return service.buscarEducacion(id);
    }
    
    @DeleteMapping("/educacion/eliminar/{id}")
    public void borrarEducacion(@PathVariable int id) {
        service.borrarEducacion(id);
    }
}
