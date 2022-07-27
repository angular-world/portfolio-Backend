package com.burgosmanuel.portfolio.seccion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private String titulo;
    private String descripcion;

    public Seccion() {
    }

    public Seccion(int id, int persona_id, String titulo, String descripcion) {
        this.id = id;
        this.persona_id = persona_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    
}
