package modelo;

import clases.Druida;
import clases.Paladin;
import razas.Enano;

import java.util.ArrayList;

public class Carga{
    //Creo el atributo que es un arraylist de personajes
    private ArrayList<Personaje> personajes;

    public Carga() {
        //Creo los 2 personajes iniciales
        Personaje mario = new Personaje("Mario", new Druida(), new Enano());
        Personaje oscar = new Personaje("Óscar", new Paladin(), new Enano());

        //Creo el arraylist
        this.personajes = new ArrayList<>();

        //Agrego los dos personajes iniciales a esa arraylist
        agregarPersonaje(this.personajes, mario);
        agregarPersonaje(this.personajes, oscar);

    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    //Creo el metodo agregarPersonaje, en el que se tiene que poner la lista y el personaje
    public void agregarPersonaje(ArrayList<Personaje> personajes, Personaje personaje){
        personajes.add(personaje);
    }

}