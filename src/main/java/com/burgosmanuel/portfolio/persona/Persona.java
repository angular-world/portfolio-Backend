package com.burgosmanuel.portfolio.persona;

import com.burgosmanuel.portfolio.security.entity.User;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Persona {

    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private User user;
    @Size(min = 4, max = 60)
    private String nombre;
    @Size(max = 80)
    @NotNull
    private String titulo;
    private String linkedin_url;
    private String github_url;
    private String img_url;
    private String banner_url;
    private String about_url;

    public Persona() {
    }

    public Persona(User user,String nombre, String titulo, String linkedin_url, String github_url, String img_url, String banner_url, String about_url) {
        this.user = user;
        this.nombre = nombre;
        this.titulo = titulo;
        this.linkedin_url = linkedin_url;
        this.github_url = github_url;
        this.img_url = img_url;
        this.banner_url = banner_url;
        this.about_url = about_url;
    }
}
