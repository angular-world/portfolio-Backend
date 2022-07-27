package com.burgosmanuel.portfolio.educacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String institucion;
    private String fecha;
    private String descripcion;

    public Educacion() {
    }

    public Educacion(int id, String titulo, String institucion, String fecha, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

}
