package com.burgosmanuel.portfolio.seccion;

import com.burgosmanuel.portfolio.security.entity.User;
import java.util.List;


public interface ISeccionService {
    public void crearSeccion(Seccion sec);
    
    public List<Seccion> listarSecciones();
    
    public void eliminarSeccion(Long id);
    
    public void editarSeccion(Long id, Seccion datosSeccion);
    
    public Seccion buscarSeccion(Long id);
    
    public void crearSeccionesDefault(Long persona_id);
}
