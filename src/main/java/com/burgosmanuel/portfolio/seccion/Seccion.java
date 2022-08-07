package com.burgosmanuel.portfolio.seccion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int persona_id;
    @Size(max = 45)
    private String titulo;
    @Size(max = 500)
    private String descripcion;

    public Seccion() {
    }

    public Seccion(int persona_id, String titulo, String descripcion) {
        this.persona_id = persona_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

}
