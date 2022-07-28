package com.burgosmanuel.portfolio.proyecto;

import java.util.List;


public interface IProyectoService {
    public void agregarProyecto(Proyecto proj);
    
    public void editarProyecto(int id, Proyecto datosProyecto);
    
    public Proyecto buscarProyecto(int id);
    
    public List<Proyecto> listarProyectos();
    
    public void borrarProyecto(int id);  
}
