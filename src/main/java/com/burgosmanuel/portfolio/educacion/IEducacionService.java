package com.burgosmanuel.portfolio.educacion;

import com.burgosmanuel.portfolio.security.entity.User;
import java.util.List;

public interface IEducacionService {
    public void agregarEducacion(Educacion edu);
    
    public void editarEducacion(Long id, Educacion datosEducacion);
    
    public List<Educacion> listarEducacion();
    
    public Educacion buscarEducacion(Long id);
    
    public void borrarEducacion(Long id);
    
    public void crearEducacionDefault(Long persona_id);
}
