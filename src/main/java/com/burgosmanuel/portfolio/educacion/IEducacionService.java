package com.burgosmanuel.portfolio.educacion;

import java.util.List;

public interface IEducacionService {
    public void agregarEducacion(Educacion edu);
    
    public void editarEducacion(int id, Educacion datosEducacion);
    
    public List<Educacion> listarEducacion();
    
    public Educacion buscarEducacion(int id);
    
    public void borrarEducacion(int id);
}
