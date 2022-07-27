package com.burgosmanuel.portfolio.experiencia;

import java.util.List;

public interface IExperienciaService {
    public void agregarExperiencia(Experiencia exp);
    
    public void editarExperiencia(int id, Experiencia datosExperiencia);
    
    public List<Experiencia> listarExperiencia();
    
    public Experiencia buscarExperiencia(int id);
    
    public void borrarExperiencia(int id);
}
