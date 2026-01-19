package habilidades;

import modelo.Personaje;

public interface Habilidades {

    //Creo la interfaz habilidades y sus atributos y metodos

    String getNombre();
    int poder();
    int usosRestantes();
    void usar(Personaje atacante, Personaje objetivo);
    void reinicioUsos();
}

