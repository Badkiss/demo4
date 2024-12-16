package org.example.demo4;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Control {




   public void  brodcast(Mensaje mensaje,ArrayList<Socket> clientes){
         for (Socket socket : clientes){
            try {
                  OutputStream out = socket.getOutputStream();
                  ObjectOutputStream writer = new ObjectOutputStream(new ObjectOutputStream(out));
                  writer.writeObject(mensaje);
                  writer.flush();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }

         }
   }

}
