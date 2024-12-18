package org.example.demo4;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTCP {
    static  Control control = new Control();
    static private ArrayList<ObjectOutputStream> clientes;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5566);
            clientes = new ArrayList<>();
            while (true){
                Socket socket = serverSocket.accept();
                Canal canal=new Canal(socket,control);
                canal.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<ObjectOutputStream> getClientes() {
        return clientes;
    }
    public  static void addClientes(ObjectOutputStream cliente) {
        clientes.add(cliente);
    }
}
