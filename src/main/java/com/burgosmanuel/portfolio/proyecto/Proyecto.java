package com.burgosmanuel.portfolio.proyecto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int persona_id;
    private String titulo;
    private String descripcion;
    private String img_url;
    private String demo_url;
    private String repo_url;

    public Proyecto() {
    }

    public Proyecto(int id, int persona_id, String titulo, String descripcion, String img_url, String demo_url, String repo_url) {
        this.id = id;
        this.persona_id = persona_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img_url = img_url;
        this.demo_url = demo_url;
        this.repo_url = repo_url;
    }

}
