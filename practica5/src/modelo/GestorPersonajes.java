package modelo;

import java.util.ArrayList;

public class GestorPersonajes {
    //Creo los atributos
    private ArrayList<Personaje> personajes;
    private Carga carga;

    public GestorPersonajes() {
        //Creo un objeto carga (que ya tiene los personajes iniciales)
        this.carga = new Carga();
        //La lista personajes tendrá los personajes que tiene la lista de carga (los iniciales)
        this.personajes = carga.getPersonajes();
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
