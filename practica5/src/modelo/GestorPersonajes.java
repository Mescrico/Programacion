package modelo;

import java.util.ArrayList;

public class GestorPersonajes {
    private ArrayList<Personaje> personajes;
    private Carga carga;
    public GestorPersonajes() {
        this.carga = new Carga();
        this.personajes = carga.getPersonajes();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
