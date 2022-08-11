package com.burgosmanuel.portfolio.proyecto;

import com.burgosmanuel.portfolio.security.entity.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private User user;
    private String titulo;
    @Size(max = 500)
    private String descripcion;
    private String img_url;
    private String demo_url;
    private String repo_url;

    public Proyecto() {
    }

    public Proyecto(String titulo, String descripcion, String img_url, String demo_url, String repo_url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img_url = img_url;
        this.demo_url = demo_url;
        this.repo_url = repo_url;
    }

}
