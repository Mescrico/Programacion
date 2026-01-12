package presentacion;

import clases.Clase;
import modelo.Creacion;
import modelo.Personaje;
import razas.Raza;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Presentacion {
    Scanner s = new Scanner(System.in);
    private Creacion creacion;
    public Presentacion(Creacion creacion) {
        this.creacion = creacion;
    }

    public void mostrarClases() {
        ArrayList<Clase> clases = creacion.getClases();
        for (int i = 0; i < clases.size(); i++) {
            System.out.println(i + ".- "+ clases.get(i).getClass().getSimpleName());
        }
    }

    public void mostrarRazas() {
        ArrayList<Raza> razas = creacion.getRazas();
        for (int i = 0; i < razas.size(); i++) {
            System.out.println(i + ".- "+ razas.get(i).getClass().getSimpleName());
        }
    }

    public void mostrarPersonajes() {
        ArrayList<Personaje> personajes = creacion.getPersonajes();
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println(i + ".- "+ personajes.get(i).getNombre() +" "+ personajes.get(i).getClase() +" "+ personajes.get(i).getRaza());
        }
    }

    public void menu() {
        System.out.println("MENU");
        System.out.println("0.- PERSONAJES");
        System.out.println("1.- JUGAR");
        System.out.println("2.- CREAR PERSONAJE");
        System.out.println("-------------------------");
        int opcion = s.nextInt();

        switch (opcion) {
            case 0:
                System.out.println("PERSONAJES EXISTENTES");
                mostrarPersonajes();
                break;
            case 1:
                System.out.println("SELECCIONA DOS JUGADORES");
                mostrarPersonajes();
                int jugador1 = s.nextInt();
                int jugador2 = s.nextInt();

                if(jugador1 < 0 || jugador2 < 0 || jugador1 >= creacion.getPersonajes().size() || jugador2 >= creacion.getPersonajes().size()) {
                    System.out.println("Elige un numero de la lista");
                    return;
                }
                //tengo que poner aqui el combate
                break;
            case 2:
                System.out.println("CREACIÓN DEL PERSONAJE");

                System.out.println("Introduce el nombre");
                String nombre = s.nextLine();

                System.out.println("Elige la raza");
                mostrarRazas();
                int opraza = s.nextInt();
                if (opraza < 0 || opraza >= creacion.getRazas().size()) {
                    System.out.println("Elige un número de la lista");
                    return;
                }

                System.out.println("Elige la clase");
                mostrarClases();
                int opclase = s.nextInt();
                if (opclase < 0 || opclase >= creacion.getClases().size()) {
                    System.out.println("Elige un número de la lista");
                    return;
                }

                creacion.crearPersonaje(nombre, opclase, opraza);

                System.out.println("PERSONAJE CREADO");
                System.out.println(creacion.getPersonajes().getLast().getNombre() + " " + creacion.getPersonajes().getLast().getRaza() + " " + creacion.getPersonajes().getLast().getClase());
                break;
        }
    }
}
