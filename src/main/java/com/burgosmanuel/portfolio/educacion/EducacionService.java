package com.burgosmanuel.portfolio.educacion;

import com.burgosmanuel.portfolio.security.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    EducacionRepository repo;
    @Autowired
    UserRepository userRepo;

    @Override
    public void agregarEducacion(Educacion edu) {
        repo.save(edu);
    }

    @Override
    public void editarEducacion(Long id, Educacion datosEducacion) {
        Educacion edu = buscarEducacion(id);
        edu = datosEducacion;
        repo.save(edu);
    }

    @Override
    public List<Educacion> listarEducacion() {
        return repo.findAll();
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void borrarEducacion(Long id) {
        Educacion edu = buscarEducacion(id);
        repo.delete(edu);
    }

    @Override
    public void crearEducacionDefault(Long persona_id) {
        Educacion eduDefault = new Educacion("Título", "Institución", "Inicio - Fin", "Descripción...");
        eduDefault.setUser(userRepo.findById(persona_id).orElse(null));
        repo.save(eduDefault);
    }
;

}
