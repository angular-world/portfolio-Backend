package com.burgosmanuel.portfolio.persona;

public interface IPersonaService {
    public Persona buscarPersona(int id);
    public void crearPersona(Persona pers);
    public void editarPersona(int id, Persona datosPersona);
}
