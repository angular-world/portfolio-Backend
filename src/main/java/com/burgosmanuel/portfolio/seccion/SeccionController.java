package com.burgosmanuel.portfolio.seccion;

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
@RequestMapping("/secciones")
public class SeccionController {

    @Autowired
    SeccionService service;

    @PostMapping("/crear")
    @PreAuthorize("hasRole('ADMIN')")
    public void crearSeccion(@RequestBody Seccion sec) {
        service.crearSeccion(sec);
    }

    @GetMapping("/listar")
    public List<Seccion> listarSecciones() {
        return service.listarSecciones();
    }

    @GetMapping("/{id}")
    public Seccion buscarSeccion(@PathVariable Long id) {
        return service.buscarSeccion(id);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void editarSeccion(@PathVariable Long id, @RequestBody Seccion sec) {
        service.editarSeccion(id, sec);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarSeccion(@PathVariable Long id) {
        service.eliminarSeccion(id);
    }
}
