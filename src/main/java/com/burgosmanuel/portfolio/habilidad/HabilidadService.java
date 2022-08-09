package com.burgosmanuel.portfolio.habilidad;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    HabilidadRepository repo;

    @Override
    public void agregarHabilidad(Habilidad hab) {
        repo.save(hab);
    }

    @Override
    public void editarHabilidad(Long id, Habilidad datosHabilidad) {
        Habilidad hab = buscarHabilidad(id);
        hab = datosHabilidad;
        repo.save(hab);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Habilidad> listarHabilidades() {
        return repo.findAll();
    }

    @Override
    public void borrarHabilidad(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void crearHabilidadDefault(Long persona_id) {
        Habilidad defaultFront = new Habilidad(persona_id, "Frontend", "Intermedio", "Habilidad Front #1", 80, "fa-brands fa-angular");
        Habilidad defaultBack = new Habilidad(persona_id, "Backend", "Intermedio", "Habilidad Back #1", 80, "fa-brands fa-java");
        Habilidad defaultSoft = new Habilidad(persona_id, "Soft", "", "Habilidad Blanda #1", 100, "fa-solid fa-comment-dots");

        repo.save(defaultFront);
        repo.save(defaultBack);
        repo.save(defaultSoft);
    }
;

}
