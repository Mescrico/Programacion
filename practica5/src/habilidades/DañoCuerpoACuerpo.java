package habilidades;

import clases.Picaro;
import modelo.Personaje;

public class DañoCuerpoACuerpo implements Habilidades{
    private int usos = 5;
    private String nombre;

    public DañoCuerpoACuerpo(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int poder() {
        return 15;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }

    @Override
    public int usar(Personaje atacante, Personaje objetivo) {
        if (atacante.getClase() ==);
    }
}
