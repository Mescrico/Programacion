package clases;

import habilidades.Habilidades;

import java.util.ArrayList;

public interface Clase {
    int bonoFuerza();
    int bonoInteligencia();
    int bonoDestreza();
    int vidaMaxima();

    ArrayList<Habilidades> habilidades();

}
