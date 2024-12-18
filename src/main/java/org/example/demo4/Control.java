package org.example.demo4;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Control {

   public void  brodcast(Mensaje mensaje,ArrayList<ObjectOutputStream> clientes){
         for (ObjectOutputStream  oos : clientes){
            try {
                  oos.writeObject(mensaje);
                  oos.flush();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }

         }
   }

}
