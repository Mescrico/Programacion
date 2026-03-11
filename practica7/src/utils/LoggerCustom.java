package utils;

import java.io.*;
import java.time.LocalDateTime;

public class LoggerCustom {

    public static void log(String mensaje) {
        String path = "practica7/Ficheros/errores.log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(mensaje);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}