package com.burgosmanuel.portfolio.seccion;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionService implements ISeccionService {

    @Autowired
    SeccionRepository repo;

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
    public void crearSeccionesDefault(Long personaId) {
        Seccion about = new Seccion(personaId, "Sobre mí", "Ingresa aquí tu información personal...");
        Seccion skills = new Seccion(personaId, "Habilidades", "Ingresa infromación de tus habilidades aquí...");
        Seccion projects = new Seccion(personaId, "Proyectos", "Ingresa infromación de tus proyectos aquí...");
        Seccion contact = new Seccion(personaId, "Contacto", "Ingresa información de contacto aquí..");

        List<Seccion> listaSecciones = new ArrayList<Seccion>();
        
        listaSecciones.add(about);
        listaSecciones.add(skills);
        listaSecciones.add(projects);
        listaSecciones.add(contact);
        
        for(Seccion seccion : listaSecciones){
            repo.save(seccion);
        }

    }

}
