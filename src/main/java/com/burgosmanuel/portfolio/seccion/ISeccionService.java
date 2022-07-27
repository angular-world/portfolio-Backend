package com.burgosmanuel.portfolio.seccion;

import java.util.List;


public interface ISeccionService {
    public void crearSeccion(Seccion sec);
    
    public List<Seccion> listarSecciones();
    
    public void eliminarSeccion(int id);
    
    public void editarSeccion(int id, Seccion datosSeccion);
    
    public Seccion buscarSeccion(int id);
}
