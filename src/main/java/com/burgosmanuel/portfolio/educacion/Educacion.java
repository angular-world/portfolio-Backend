package com.burgosmanuel.portfolio.educacion;

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
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private User user;
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

    public Educacion(String titulo, String institucion, String fecha, String descripcion) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

}
