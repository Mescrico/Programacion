package utils;

import java.io.*;
import java.time.LocalDateTime;

public class LoggerCustom {

    public static void log(String mensaje) {
        //Pongo la ruta donde van a ir los logs
        String path = "practica7/Ficheros/errores.log";
        //Creamos un bufferedwriter que contiene la ruta del archivo a traves del filewriter, le ponemos que no sobreescriba sino que añada
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            //Escribimos el mensaje y hacemos un salto de linea para el proximo mensaje
            writer.write(mensaje);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}