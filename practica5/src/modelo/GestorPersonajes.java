package modelo;

import java.util.ArrayList;

public class GestorPersonajes {
    private ArrayList<Personaje> personajes = new ArrayList<>();

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}
