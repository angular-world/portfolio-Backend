package com.burgosmanuel.portfolio.habilidad;

import java.util.List;

public interface IHabilidadService {

    public void agregarHabilidad(Habilidad hab);
    
    public void editarHabilidad(int id, Habilidad datsoHabilidad);
    
    public Habilidad buscarHabilidad(int id);
    
    public List<Habilidad> listarHabilidades();
    
    public void borrarHabilidad(int id);
    
}
