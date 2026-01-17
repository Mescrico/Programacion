package habilidades;

import modelo.Personaje;

public interface Habilidades {
    String getNombre();
    int poder();
    int usosRestantes();
    void usar(Personaje atacante, Personaje objetivo);

    void reinicioUsos();
}

