package com.burgosmanuel.portfolio.seccion;

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
public class SeccionController {

    @Autowired
    SeccionService service;

    @PostMapping("/secciones/crear")
    public void crearSeccion(@RequestBody Seccion sec) {
        service.crearSeccion(sec);
    }

    @GetMapping("/secciones")
    public List<Seccion> listarSecciones() {
        return service.listarSecciones();
    }

    @GetMapping("/secciones/{id}")
    public Seccion buscarSeccion(@PathVariable int id) {
        return service.buscarSeccion(id);
    }

    @PutMapping("/secciones/editar/{id}")
    public void editarSeccion(@PathVariable int id, @RequestBody Seccion sec){  
        service.editarSeccion(id, sec);
    }
    
    @DeleteMapping("/secciones/eliminar/{id}")
    public void eliminarSeccion(@PathVariable int id){
        service.eliminarSeccion(id);
    }
}
