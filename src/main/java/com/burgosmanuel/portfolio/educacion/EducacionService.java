package com.burgosmanuel.portfolio.educacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    EducacionRepository repo;

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
    public void crearEducacionDefault(Long persona_id){
        Educacion eduDefault = new Educacion(persona_id, "Título", "Institución", "Inicio - Fin", "Descripción...");
        
        repo.save(eduDefault);
    };

}
