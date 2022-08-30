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
    private String receptor;
    private String mensaje;

    public Email() {
    }

    public Email(String nombre, String emisor, String receptor, String mensaje) {
        this.nombre = nombre;
        this.emisor = emisor;
        this.receptor = receptor;
        this.mensaje = mensaje;
    }

}
