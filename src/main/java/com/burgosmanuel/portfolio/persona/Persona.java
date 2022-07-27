package com.burgosmanuel.portfolio.persona;

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
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(max = 45)
    private String nombre;
    @Size(max = 45)
    private String titulo;
    @Size(max = 45)
    private String email;
    @Size(max = 60)
    private String linkedin_url;
    @Size(max = 60)
    private String github_url;
    @Size(max = 100)
    private String img_url;
    @Size(max = 100)
    private String banner_url;
    @Size(max = 100)
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
