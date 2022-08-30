package com.burgosmanuel.portfolio.email;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Email {

    private String nombre;
    private String emisor;
    private Long receptor_id;
    private String mensaje;

    public Email() {
    }

    public Email(String nombre, String emisor, Long receptor_id, String mensaje) {
        this.nombre = nombre;
        this.emisor = emisor;
        this.receptor_id = receptor_id;
        this.mensaje = mensaje;
    }

}
