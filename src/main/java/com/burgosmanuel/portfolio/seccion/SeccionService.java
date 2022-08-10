package com.burgosmanuel.portfolio.seccion;

import com.burgosmanuel.portfolio.security.entity.User;
import com.burgosmanuel.portfolio.security.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionService implements ISeccionService {

    @Autowired
    SeccionRepository repo;
    @Autowired
    UserRepository userRepo;

    @Override
    public void crearSeccion(Seccion sec) {
        repo.save(sec);
    }

    @Override
    public List<Seccion> listarSecciones() {
        return repo.findAll();
    }

    @Override
    public Seccion buscarSeccion(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void editarSeccion(Long id, Seccion datosSeccion) {
        Seccion sec = buscarSeccion(id);
        sec = datosSeccion;
        repo.save(sec);
    }

    @Override
    public void eliminarSeccion(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void crearSeccionesDefault(Long persona_id) {
        Seccion about = new Seccion("Sobre mí", "Ingresa aquí tu información personal...");
        about.setUser(userRepo.findById(persona_id).orElse(null));
        Seccion skills = new Seccion("Habilidades", "Ingresa infromación de tus habilidades aquí...");
        skills.setUser(userRepo.findById(persona_id).orElse(null));
        Seccion projects = new Seccion("Proyectos", "Ingresa infromación de tus proyectos aquí...");
        projects.setUser(userRepo.findById(persona_id).orElse(null));
        Seccion contact = new Seccion("Contacto", "Ingresa información de contacto aquí..");
        contact.setUser(userRepo.findById(persona_id).orElse(null));
        
        List<Seccion> listaSecciones = new ArrayList<Seccion>();

        listaSecciones.add(about);
        listaSecciones.add(skills);
        listaSecciones.add(projects);
        listaSecciones.add(contact);

        for (Seccion seccion : listaSecciones) {
            repo.save(seccion);
        }

    }

}
