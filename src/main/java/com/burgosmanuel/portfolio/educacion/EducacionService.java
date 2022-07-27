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
    public void editarEducacion(int id, Educacion datosEducacion) {
        Educacion edu = buscarEducacion(id);
        edu = datosEducacion;
        repo.save(edu);
    }

    @Override
    public List<Educacion> listarEducacion() {
        return repo.findAll();
    }

    @Override
    public Educacion buscarEducacion(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void borrarEducacion(int id) {
        Educacion edu = buscarEducacion(id);
        repo.delete(edu);
    }
}
