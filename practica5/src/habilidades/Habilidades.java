package habilidades;

import modelo.Personaje;

public interface Habilidades {
    String getNombre();
    int poder();
    int usosRestantes();

    int usar(Personaje atacante, Personaje objetivo);

}
