package presentacion;

import clases.Clase;
import modelo.Combate;
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
            System.out.println(i + ".- "+ personajes.get(i).getNombre() +": "+ personajes.get(i).getClase().getClass().getSimpleName() +" "+ personajes.get(i).getRaza().getClass().getSimpleName());
        }
    }


    public void menu() {
        boolean terminar = false;
        do {
            System.out.println("MENU");
            System.out.println("1.- PERSONAJES");
            System.out.println("2.- JUGAR");
            System.out.println("3.- CREAR PERSONAJE");
            System.out.println("0.- SALIR");
            System.out.println("-------------------------");
            int opcion = s.nextInt();
            System.out.println("-------------------------");

            switch (opcion) {
                case 1:
                    System.out.println("PERSONAJES EXISTENTES");
                    mostrarPersonajes();
                    System.out.println("-------------------------");
                    break;
                case 2:
                    System.out.println("SELECCIONA DOS JUGADORES");
                    mostrarPersonajes();
                    int jugador1 = s.nextInt();
                    int jugador2 = s.nextInt();

                    if (jugador1 < 0 || jugador2 < 0 || jugador1 >= creacion.getPersonajes().size() || jugador2 >= creacion.getPersonajes().size()) {
                        System.out.println("Elige un numero de la lista");
                        continue;
                    }

                    Personaje jugadorElegido1 = creacion.getPersonajes().get(jugador1);
                    Personaje jugadorElegido2 = creacion.getPersonajes().get(jugador2);

                    Combate combate = new Combate();
                    combate.combate(jugadorElegido1, jugadorElegido2);
                    break;
                case 3:
                    System.out.println("CREACIÓN DEL PERSONAJE");

                    System.out.println("Introduce el nombre");
                    String nombre = s.next();


                    boolean existe;
                    int opraza;
                    do {
                        System.out.println("Elige la raza");
                        mostrarRazas();
                        existe = false;
                        opraza = s.nextInt();
                        if (opraza < 0 || opraza >= creacion.getRazas().size()) {
                            System.out.println("Elige un número de la lista");
                            System.out.println("-------------------------");
                        } else {
                            existe = true;
                        }
                    } while(!existe);

                    int opclase;
                    do{
                        System.out.println("Elige la clase");
                        mostrarClases();
                        existe = false;
                        opclase = s.nextInt();
                        if (opclase < 0 || opclase >= creacion.getClases().size()) {
                            System.out.println("Elige un número de la lista");
                            System.out.println("-------------------------");
                        } else {
                            existe = true;
                        }
                    } while(!existe);

                    creacion.crearPersonaje(nombre, opclase, opraza);

                    System.out.println("PERSONAJE CREADO");
                    System.out.println(creacion.getPersonajes().getLast().getNombre() + ": " + creacion.getPersonajes().getLast().getRaza().getClass().getSimpleName() + " " + creacion.getPersonajes().getLast().getClase().getClass().getSimpleName());
                    break;
                case 0:
                    terminar = true;
                    break;
                default:
                    break;
            }

        } while(!terminar);
    }
}
