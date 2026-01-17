package modelo;

import clases.Druida;
import clases.Paladin;
import razas.Enano;

import java.util.ArrayList;

public class Carga{
    private ArrayList<Personaje> personajes;

    public Carga() {
        Personaje mario = new Personaje("Mario", new Druida(), new Enano());
        Personaje oscar = new Personaje("Óscar", new Paladin(), new Enano());
        this.personajes = new ArrayList<>();
        agregarPersonaje(this.personajes, mario);
        agregarPersonaje(this.personajes, oscar);

    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public void agregarPersonaje(ArrayList<Personaje> personajes, Personaje personaje){
        personajes.add(personaje);
    }

}