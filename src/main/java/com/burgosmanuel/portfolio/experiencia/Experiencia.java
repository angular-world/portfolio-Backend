package com.burgosmanuel.portfolio.experiencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    ;
    private int persona_id;
    @Size(max = 45)
    private String puesto;
    @Size(max = 45)
    private String empleador;
    @Size(max = 45)
    private String fecha;
    @Size(max = 300)
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(int persona_id, String puesto, String empleador, String fecha, String descripcion) {
        this.persona_id = persona_id;
        this.puesto = puesto;
        this.empleador = empleador;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

}
