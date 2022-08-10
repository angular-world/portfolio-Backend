package com.burgosmanuel.portfolio.habilidad;

import com.burgosmanuel.portfolio.security.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    HabilidadRepository repo;
    @Autowired
    UserRepository userRepo;

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
        Habilidad defaultFront = new Habilidad("Frontend", "Intermedio", "Habilidad Front #1", 80, "fa-brands fa-angular");
        defaultFront.setUser(userRepo.findById(persona_id).orElse(null));
        Habilidad defaultBack = new Habilidad("Backend", "Intermedio", "Habilidad Back #1", 80, "fa-brands fa-java");
        defaultBack.setUser(userRepo.findById(persona_id).orElse(null));
        Habilidad defaultSoft = new Habilidad("Soft", "", "Habilidad Blanda #1", 100, "fa-solid fa-comment-dots");
        defaultSoft.setUser(userRepo.findById(persona_id).orElse(null));
        repo.save(defaultFront);
        repo.save(defaultBack);
        repo.save(defaultSoft);
    }
;

}
