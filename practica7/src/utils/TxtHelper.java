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
        try (var file = new BufferedWriter(new FileWriter("practica7/Ficheros/errores.log", true))){
            List<String> lineas = Files.readAllLines(Paths.get("practica7/Ficheros/ciudades.txt"));
            if(lineas.isEmpty()) {
                file.write("["+LocalDateTime.now()+"] ERROR: FormatoInvalidoException - Fichero vacío");
                file.newLine();
                throw new FormatoInvalidoException("Fichero vacío");
            }
            List<Ciudad> ciudades = new ArrayList<>();
            for (String linea : lineas) {
                try {
                    System.out.println(linea);
                    String[] lineaN = linea.split(";");
                    if(lineaN.length != 4) {
                        throw new DatoInvalidoException("Fichero Invalido");
                    }
                    Ciudad c = new Ciudad(lineaN[0], Integer.parseInt(lineaN[1]), lineaN[2], Integer.parseInt(lineaN[3]));
                    ciudades.add(c);
                } catch (Exception e) {
                    file.write("["+LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
                    file.newLine();
                }

            }
            return ciudades;
        } catch (IOException e) {
            System.out.println("No se ha encontrado el fichero");
            return List.of();
        } catch (FormatoInvalidoException e) {
            System.out.println("El fichero tiene un formato inválido");
            return List.of();
        }
    }
}
