package com.burgosmanuel.portfolio.nivel_habilidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//@Entity -> Eliminamos ya que no la utilizamos por ahora
@Getter
@Setter
public class NivelHabilidad {

    @Id
    private int id;
    @Size(max = 45)
    private String nivel_habilidad;

    public NivelHabilidad() {
    }

    public NivelHabilidad(int id, String nivel_habilidad) {
        this.id = id;
        this.nivel_habilidad = nivel_habilidad;
    }

}
