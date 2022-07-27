package com.burgosmanuel.portfolio.habilidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;;
    private int persona_id;
    private int tipo_habilidad_id;
    private int nivel_habilidad_id;
    private String nombre;
    private int progreso;
    private String icono;

    public Habilidad() {
    }

    public Habilidad(int id, int persona_id, int tipo_habilidad_id, int nivel_habilidad_id, String nombre, int progreso, String icono) {
        this.id = id;
        this.persona_id = persona_id;
        this.tipo_habilidad_id = tipo_habilidad_id;
        this.nivel_habilidad_id = nivel_habilidad_id;
        this.nombre = nombre;
        this.progreso = progreso;
        this.icono = icono;
    }
}
