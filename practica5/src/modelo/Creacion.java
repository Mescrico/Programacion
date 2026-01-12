package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import clases.*;
import razas.*;

public class Creacion {
    private Carga carga;
    private ArrayList<Clase> clases = new ArrayList<>();
    private ArrayList<Raza> razas = new ArrayList<>();
    private ArrayList<Personaje> personajes = new ArrayList<>();
    private Personaje personaje1;

    public Creacion() {
        this.carga = new Carga();

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

        personajes = carga.getPersonajes();
    }
    public void crearPersonaje(String nombre, int clase, int raza) {
        Clase clase1 = clases.get(clase);
        Raza raza1 = razas.get(raza);
        Personaje personaje1 = new Personaje(nombre, clase1, raza1);
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
//Hacemos la opcion de crear personaje aqui