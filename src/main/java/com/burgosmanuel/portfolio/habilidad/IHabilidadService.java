package com.burgosmanuel.portfolio.habilidad;

import java.util.List;

public interface IHabilidadService {

    public void agregarHabilidad(Habilidad hab);
    
    public void editarHabilidad(Long id, Habilidad datsoHabilidad);
    
    public Habilidad buscarHabilidad(Long id);
    
    public List<Habilidad> listarHabilidades();
    
    public void borrarHabilidad(Long id);
    
}
