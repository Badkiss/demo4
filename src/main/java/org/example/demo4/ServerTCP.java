package org.example.demo4;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    static Control control = new Control();
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5566);
            while (true){
                Socket socket = serverSocket.accept();
                Canal canal=new Canal(socket);
                control.add(socket);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
