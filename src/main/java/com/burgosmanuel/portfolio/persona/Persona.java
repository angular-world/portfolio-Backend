package com.burgosmanuel.portfolio.persona;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String titulo;
    private String email;
    private String linkedin_url;
    private String github_url;
    private String img_url;
    private String banner_url;
    private String about_url;

    public Persona() {
    }

    public Persona(int id, String nombre, String titulo, String email, String linkedin_url, String github_url, String img_url, String banner_url, String about_url) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.email = email;
        this.linkedin_url = linkedin_url;
        this.github_url = github_url;
        this.img_url = img_url;
        this.banner_url = banner_url;
        this.about_url = about_url;
    }

}
