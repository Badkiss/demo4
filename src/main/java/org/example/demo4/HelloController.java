package org.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloController {
    @FXML
    private TextField IP;
    @FXML
    private TextField puerto;
    @FXML
    private TextField nombre;
    @FXML
    private Button start;
    @FXML
    private Button Enviar;
    @FXML
    private TextField mensaje;

    Escucha escucha;
    String ip;
    String name;
    String port;
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    @FXML
    protected void onStart() {
        try {
            String ip1 = IP.getText();
            int port1 = Integer.parseInt(puerto.getText());
            String name1 = nombre.getText();
            ip = ip1;
            port = String.valueOf(port1);
            name = name1;
             socket =new Socket(ip1,port1);
             oos =new ObjectOutputStream(socket.getOutputStream());
             ois =new ObjectInputStream(socket.getInputStream());
             escucha = new Escucha(ois);
             escucha.start();

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onEnviar() {
        try {
            oos.writeObject(new Mensaje(ip,mensaje.getText(),name));
            mensaje.setText("");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}