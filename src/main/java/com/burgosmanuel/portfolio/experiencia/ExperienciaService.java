package com.burgosmanuel.portfolio.experiencia;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    ExperienciaRepository repo;

    @Override
    public void agregarExperiencia(Experiencia exp) {
        repo.save(exp);
    }

    @Override
    public void editarExperiencia(Long id, Experiencia datosExperiencia) {
        Experiencia exp = buscarExperiencia(id);
        exp = datosExperiencia;
        repo.save(exp);
    }

    @Override
    public List<Experiencia> listarExperiencia() {
        return repo.findAll();
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void borrarExperiencia(Long id) {
        Experiencia exp = buscarExperiencia(id);
        repo.delete(exp);
    }
}
