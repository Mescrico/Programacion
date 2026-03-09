package utils;

import java.io.*;
import java.time.LocalDateTime;

public class LoggerCustom {

    private static final String path = "practica7/Ficheros/errores.log";

    public static void log(String mensaje) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(mensaje);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}