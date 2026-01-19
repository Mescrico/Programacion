package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import clases.*;
import razas.*;

public class Creacion {
    //Creo los atributos
    private GestorPersonajes gestor;
    //Creo un arraylist de clases y razas
    private ArrayList<Clase> clases = new ArrayList<>();
    private ArrayList<Raza> razas = new ArrayList<>();

    //Llamo a una lista personajes
    private ArrayList<Personaje> personajes;

    public Creacion() {
        //Creamos la clase gestor en el que dentro hay una clase carga creada con los personajes iniciales en una lista
        this.gestor = new GestorPersonajes();

        //Precargamos cada clase y raza
        clases.add(new Bardo());
        clases.add(new Druida());
        clases.add(new Guerrero());
        clases.add(new Mago());
        clases.add(new Monje());
        clases.add(new Paladin());
        clases.add(new Picaro());
        clases.add(new Sacerdote());

        razas.add(new Elfo());
        razas.add(new Enano());
        razas.add(new Humano());

        //Añadimos a la lista personajes, los personajes que tiene el gestor, que son los iniciales
        personajes = gestor.getPersonajes();
    }

    //Creo el metodo crearPersonaje, que necesita el nombre, la clase y la raza
    public void crearPersonaje(String nombre, int clase, int raza) {
        //Lo he creado para que el usuario eliga con un numero la clase que quiere
        //Por lo que recorremos el arraylist de clases y razas con los numeros que el usuario ha elegido
        Clase clase1 = clases.get(clase);
        Raza raza1 = razas.get(raza);

        //Creamos el personaje con los parametros
        Personaje personaje1 = new Personaje(nombre, clase1, raza1);

        //Añadimos al personaje que se crea a la lista personajes
        personajes.add(personaje1);
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public ArrayList<Raza> getRazas() {
        return razas;
    }

    public void setRazas(ArrayList<Raza> razas) {
        this.razas = razas;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }
}