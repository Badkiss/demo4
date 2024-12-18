package org.example.demo4;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Escucha extends Thread {

    private ObjectInputStream in;

    public Escucha(ObjectInputStream ois) {
        try {
            in =ois;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void run() {
        while (true) {
            try {
                Mensaje mensaje = (Mensaje) in.readObject();
                System.out.println(mensaje.getNombre());
                System.out.println(mensaje.getMensaje());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
