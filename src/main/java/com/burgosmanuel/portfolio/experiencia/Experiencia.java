package com.burgosmanuel.portfolio.experiencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String puesto;
    private String empleador;
    private String fecha;
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia(int id, String puesto, String empleador, String fecha, String descripcion) {
        this.id = id;
        this.puesto = puesto;
        this.empleador = empleador;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

}