package org.example.demo4;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Control {
   private List<Socket> clientes;

   Control() {
       clientes = new ArrayList<>();
   }

   public void  brodcast(Mensaje mensaje){
         for (Socket socket : clientes){
            try {
               if (mensaje.getIp().equals(socket.getInetAddress().getHostAddress())){

               }else{
                  OutputStream out = socket.getOutputStream();
                  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                  writer.write(mensaje.getMensaje());
                  writer.newLine();
                  writer.flush();
               }
            } catch (Exception e) {
               throw new RuntimeException(e);
            }

         }
   }
   public void add(Socket socket){
      clientes.add(socket);
   }
}
