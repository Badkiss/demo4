package org.example.demo4;

import java.io.Serializable;
import java.net.Socket;

public class Mensaje implements Serializable {
    private String ip;
    private String mensaje;
    private String nombre;

    Mensaje(String ip, String mensaje,String nombre) {
        this.ip = ip;
        this.mensaje = mensaje;
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public String getMensaje() {
        return mensaje;
    }
    public String getNombre() {
        return nombre;
    }
}
