package com.burgosmanuel.portfolio.proyecto;

import com.burgosmanuel.portfolio.security.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    ProyectoRepository repo;
    @Autowired
    UserRepository userRepo;

    @Override
    public void agregarProyecto(Proyecto proj) {
        repo.save(proj);
    }

    @Override
    public void editarProyecto(Long id, Proyecto datosProyecto) {
        Proyecto proj = buscarProyecto(id);
        proj = datosProyecto;
        repo.save(proj);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> listarProyectos() {
        return repo.findAll();
    }

    @Override
    public void borrarProyecto(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void crearProyectoDefault(Long persona_id) {
        Proyecto proyectoDefault = new Proyecto("Titulo", "Descripcion de tu proyecto", "https://cabaretfestival.es/wp-content/uploads/2020/07/Hero-Banner-Placeholder-Light-1024x480-1.png", "https://google.com", "https://google.com");
        proyectoDefault.setUser(userRepo.findById(persona_id).orElse(null));
        repo.save(proyectoDefault);
    }

}
