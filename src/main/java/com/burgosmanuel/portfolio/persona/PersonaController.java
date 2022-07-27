package com.burgosmanuel.portfolio.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PersonaController {

    @Autowired
    PersonaService service;

    @GetMapping("/personas/{id}")
    public Persona buscarPersona(@PathVariable int id) {
        return service.buscarPersona(id);
    }

    @PostMapping("personas/crear")
    public void crearPersona(@RequestBody Persona pers) {
        service.crearPersona(pers);
    }

    @PutMapping("personas/editar/{id}")
    public void editarPersona(@PathVariable int id, @RequestBody Persona datosPersona) {
        service.editarPersona(id, datosPersona);
    }
}
