package com.burgosmanuel.portfolio.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository repo;

    @Override
    public Persona buscarPersona(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void crearPersona(Persona pers) {
        repo.save(pers);
    }

    @Override
    public void editarPersona(Long id, Persona datosPersona) {
        Persona pers = buscarPersona(id);
        pers = datosPersona;
        repo.save(pers);
    }
}
