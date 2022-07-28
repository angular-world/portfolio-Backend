package com.burgosmanuel.portfolio.proyecto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    ProyectoRepository repo;
    
    @Override
    public void agregarProyecto(Proyecto proj) {
        repo.save(proj);
    }
    
    @Override
    public void editarProyecto(int id, Proyecto datosProyecto) {
        Proyecto proj = buscarProyecto(id);
        proj = datosProyecto;
        repo.save(proj);
    }
    
    @Override
    public Proyecto buscarProyecto(int id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public List<Proyecto> listarProyectos() {
        return repo.findAll();
    }
    
    @Override
    public void borrarProyecto(int id) {
        repo.deleteById(id);
    }
    
}
