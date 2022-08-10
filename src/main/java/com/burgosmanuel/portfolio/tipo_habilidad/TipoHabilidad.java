package com.burgosmanuel.portfolio.tipo_habilidad;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TipoHabilidad {

    @Id
    private int id;
    @Size (max = 45)
    private String nombre_tipo;

    public TipoHabilidad() {
    }

    public TipoHabilidad(int id, String nombre_tipo) {
        this.id = id;
        this.nombre_tipo = nombre_tipo;
    }

}
