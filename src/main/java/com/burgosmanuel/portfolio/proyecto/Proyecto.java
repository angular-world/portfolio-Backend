package com.burgosmanuel.portfolio.proyecto;

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
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long persona_id;
    @Size(max = 45)
    private String titulo;
    @Size(max = 500)
    private String descripcion;
    @Size(max = 100)
    private String img_url;
    @Size(max = 100)
    private String demo_url;
    @Size(max = 100)
    private String repo_url;

    public Proyecto() {
    }

    public Proyecto(Long persona_id, String titulo, String descripcion, String img_url, String demo_url, String repo_url) {
        this.persona_id = persona_id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img_url = img_url;
        this.demo_url = demo_url;
        this.repo_url = repo_url;
    }

}
