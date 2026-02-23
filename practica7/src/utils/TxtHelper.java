package utils;

import model.Ciudad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TxtHelper {
    public TxtHelper() {};

    public void cargarFichero() {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("practica7/Ficheros/ciudades.txt"));
            for (String linea : lineas) {
                System.out.println(linea);
                String[] lineaN = linea.split(";");
                Ciudad c = new Ciudad(lineaN[0], Integer.parseInt(lineaN[1]), lineaN[2], Integer.parseInt(lineaN[3]));
            }
        } catch (IOException e) {
            System.out.println("No se ha encontrado el fichero");
        }
    }
}
