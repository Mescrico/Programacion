package rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerCustom {

    public static void logInfo(String mensaje) {
        //Pongo la ruta donde van a ir los logs
        String path = "practica8/Ficheros/info.log";
        //Creamos un bufferedwriter que contiene la ruta del archivo a traves del filewriter, le ponemos que no sobreescriba sino que añada
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            //Escribimos el mensaje y hacemos un salto de linea para el proximo mensaje
            writer.write("["+LocalDateTime.now()+"] INFO: "+mensaje);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error "+e.getMessage());
        }
    }

    public static void logError(String mensaje) {
        //Pongo la ruta donde van a ir los logs
        String path = "practica8/Ficheros/errores.log";
        //Creamos un bufferedwriter que contiene la ruta del archivo a traves del filewriter, le ponemos que no sobreescriba sino que añada
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            //Escribimos el mensaje y hacemos un salto de linea para el proximo mensaje
            writer.write("["+LocalDateTime.now()+"] ERROR: "+mensaje);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}