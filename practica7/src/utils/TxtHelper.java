package utils;

import handler.DatoInvalidoException;
import handler.FormatoInvalidoException;
import model.Ciudad;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    public TxtHelper() {};

    public List<Ciudad> cargarFichero() {
        try{
            List<String> lineas = Files.readAllLines(Paths.get("practica7/Ficheros/ciudades.txt"));
            try {
                if(lineas.isEmpty()) {
                    System.out.println("ciudades.txt vacio");
                    throw new FormatoInvalidoException("Fichero ciudades.txt vacío");
                }
            } catch (FormatoInvalidoException e) {
                LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
            }

            List<Ciudad> ciudades = new ArrayList<>();
            for (String linea : lineas) {
                try {
                    System.out.println(linea);
                    String[] lineaN = linea.split(";");
                    if(lineaN.length != 4) {
                        throw new DatoInvalidoException("Fichero ciudades.txt Invalido");
                    }
                    Ciudad c = new Ciudad(lineaN[0], Integer.parseInt(lineaN[1]), lineaN[2], Integer.parseInt(lineaN[3]));
                    ciudades.add(c);
                    System.out.println(ciudades);
                } catch (DatoInvalidoException e) {
                    LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
                }

            }
            return ciudades;
        } catch (IOException e) {
            LoggerCustom.log("[" + LocalDateTime.now() + "] ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            return List.of();
        }
    }
}
