package org.example.demo4;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Canal extends Thread {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Control control;

    Canal(Socket socket,Control control) {
        try{
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            ServerTCP.addClientes(out);
            this.control = control;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void run() {
        while (true) {
            try {
                    Mensaje mensaje=(Mensaje)in.readObject();

                    control.brodcast(mensaje,ServerTCP.getClientes());
                    System.out.println(mensaje.getMensaje());




            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
