package clases;

import habilidades.Habilidades;

import java.util.ArrayList;

public interface Clase {

    //Creo la interfaz clase y sus atributos, y el metodo habilidades

    int bonoFuerza();
    int bonoInteligencia();
    int bonoDestreza();
    int vidaMaxima();
    ArrayList<Habilidades> habilidades();


}
