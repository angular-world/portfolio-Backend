package com.burgosmanuel.portfolio.habilidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int persona_id;
    @Size(max = 45)
    private String tipo;
    @Size(max = 45)
    private String nivel;
    @Size(max = 45)
    private String nombre;
    @Max(100)
    private int progreso;
    @Size(max = 100)
    private String icono;

    public Habilidad() {
    }

    public Habilidad(int id, int persona_id, String tipo, String nivel, String nombre, int progreso, String icono) {
        this.id = id;
        this.persona_id = persona_id;
        this.tipo = tipo;
        this.nivel = nivel;
        this.nombre = nombre;
        this.progreso = progreso;
        this.icono = icono;
    }
}
