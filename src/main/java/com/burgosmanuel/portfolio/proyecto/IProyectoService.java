package com.burgosmanuel.portfolio.proyecto;

import java.util.List;


public interface IProyectoService {
    public void agregarProyecto(Proyecto proj);
    
    public void editarProyecto(Long id, Proyecto datosProyecto);
    
    public Proyecto buscarProyecto(Long id);
    
    public List<Proyecto> listarProyectos();
    
    public void borrarProyecto(Long id);  
}
