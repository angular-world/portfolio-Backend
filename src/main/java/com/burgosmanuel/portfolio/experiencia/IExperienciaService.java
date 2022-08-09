package com.burgosmanuel.portfolio.experiencia;

import java.util.List;

public interface IExperienciaService {
    public void agregarExperiencia(Experiencia exp);
    
    public void editarExperiencia(Long id, Experiencia datosExperiencia);
    
    public List<Experiencia> listarExperiencia();
    
    public Experiencia buscarExperiencia(Long id);
    
    public void borrarExperiencia(Long id);
}
