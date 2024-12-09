package org.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    protected void onStart() {
        try {
            String ip = IP.getText();
            int port = Integer.parseInt(puerto.getText());
            String name = nombre.getText();
            System.out.println("IP: " + ip+" PORT: "+port);

            Socket socket =new Socket(ip,port);

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}