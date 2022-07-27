package com.burgosmanuel.portfolio.seccion;

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
    public Seccion buscarSeccion(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void editarSeccion(int id, Seccion datosSeccion) {
        Seccion sec = buscarSeccion(id);
        sec = datosSeccion;
        repo.save(sec);
    }

    @Override
    public void eliminarSeccion(int id) {
        repo.deleteById(id);
    }
}
