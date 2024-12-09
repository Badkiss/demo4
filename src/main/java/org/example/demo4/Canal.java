package org.example.demo4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Canal extends Thread {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    Canal(Socket socket) {
        try{
            this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void run() {
        while (true) {

        }
    }

}
