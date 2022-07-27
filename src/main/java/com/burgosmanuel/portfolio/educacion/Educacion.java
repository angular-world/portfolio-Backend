package com.burgosmanuel.portfolio.educacion;

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
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int persona_id;
    @Size(max = 45)
    private String titulo;
    @Size(max = 45)
    private String institucion;
    @Size(max = 45)
    private String fecha;
    @Size(max = 300)
    private String descripcion;
    
    public Educacion() {
    }

    public Educacion(int id, int persona_id, String titulo, String institucion, String fecha, String descripcion) {
        this.id = id;
        this.persona_id = persona_id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

}
