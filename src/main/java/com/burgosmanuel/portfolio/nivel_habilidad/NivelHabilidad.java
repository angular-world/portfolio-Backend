package com.burgosmanuel.portfolio.nivel_habilidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NivelHabilidad {

    @Id
    private int id;
    private String nivel_habilidad;

    public NivelHabilidad() {
    }

    public NivelHabilidad(int id, String nivel_habilidad) {
        this.id = id;
        this.nivel_habilidad = nivel_habilidad;
    }

}
