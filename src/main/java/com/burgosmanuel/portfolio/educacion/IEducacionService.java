package com.burgosmanuel.portfolio.educacion;

import java.util.List;

public interface IEducacionService {
    public void agregarEducacion(Educacion edu);
    
    public void editarEducacion(Long id, Educacion datosEducacion);
    
    public List<Educacion> listarEducacion();
    
    public Educacion buscarEducacion(Long id);
    
    public void borrarEducacion(Long id);
}
