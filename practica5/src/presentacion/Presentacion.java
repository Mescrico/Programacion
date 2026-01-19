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
    //Creo un objeto creacion que contiene la lista de personajes
    private Creacion creacion;

    //Para crear un objeto presentacion pedimos que pase un objeto creacion
    public Presentacion(Creacion creacion) {
        //Presentacion ya tiene precargada las razas, clases y la lista de personajes
        this.creacion = creacion;
    }

    //Creamos el metodo mostrarClases
    public void mostrarClases() {
        //Crea un arraylist de clases y coge las clases de creacion
        ArrayList<Clase> clases = creacion.getClases();
        //Crea un bucle y muestra todas las clases
        for (int i = 0; i < clases.size(); i++) {
            System.out.println(i + ".- "+ clases.get(i).getClass().getSimpleName());
        }
    }

    //Creamos el metodo mostrarRazas
    public void mostrarRazas() {
        //Crea un arraylist de razas y coge las razas de creacion
        ArrayList<Raza> razas = creacion.getRazas();
        //Crea un bucle y muestra todas las razas
        for (int i = 0; i < razas.size(); i++) {
            System.out.println(i + ".- "+ razas.get(i).getClass().getSimpleName());
        }
    }

    //Cremos el metodo mostrarPersonajes
    public void mostrarPersonajes() {
        //Crea un arraylist de personajes y coge los personajes de creacion
        ArrayList<Personaje> personajes = creacion.getPersonajes();
        //Crea un bucle y muestra todos los personajes
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println(i + ".- "+ personajes.get(i).getNombre() +": "+ personajes.get(i).getClase().getClass().getSimpleName() +" "+ personajes.get(i).getRaza().getClass().getSimpleName());
        }
    }


    //Creamos el metodo menu que mostrara el menu
    public void menu() {
        //Creamos un boolean terminar que servira para la opcion 0
        boolean terminar = false;
        //Mientras no haya terminado hacemos lo siguiente
        do {
            //Mostramos el menu
            System.out.println("MENU");
            System.out.println("1.- PERSONAJES");
            System.out.println("2.- JUGAR");
            System.out.println("3.- CREAR PERSONAJE");
            System.out.println("0.- SALIR");
            System.out.println("-------------------------");
            int opcion = s.nextInt();
            System.out.println("-------------------------");

            //Hacemos un switch case de la opcion
            switch (opcion) {
                //Caso 1 muestra los personajes existentes
                case 1:
                    System.out.println("PERSONAJES EXISTENTES");
                    mostrarPersonajes();
                    System.out.println("-------------------------");
                    break;

                //Caso 2 pide que selecciones los 2 jugadores para el combate
                case 2:
                    System.out.println("SELECCIONA DOS JUGADORES");
                    System.out.println("-------------------------");
                    mostrarPersonajes();
                    System.out.println("PRIMER JUGADOR:");
                    int jugador1 = s.nextInt();
                    s.nextLine();
                    System.out.println("SEGUNDO JUGADOR:");
                    int jugador2 = s.nextInt();
                    s.nextLine();


                    //Comprobamos si ha elegido un numero fuera de lista
                    if (jugador1 < 0 || jugador2 < 0 || jugador1 >= creacion.getPersonajes().size() || jugador2 >= creacion.getPersonajes().size()) {
                        System.out.println("Elige un numero de la lista");
                        continue;
                    }

                    //Creamos los personajes a partir de los numeros elegidos
                    Personaje jugadorElegido1 = creacion.getPersonajes().get(jugador1);
                    Personaje jugadorElegido2 = creacion.getPersonajes().get(jugador2);

                    //Creamos un objeto nuevo de combate y llamamos a la funcion combate
                    Combate combate = new Combate();
                    combate.combate(jugadorElegido1, jugadorElegido2);
                    break;

                //Caso 3 muestra el menu de creacion del personaje
                case 3:
                    System.out.println("CREACIÓN DEL PERSONAJE");
                    System.out.println("-------------------------");

                    System.out.println("Introduce el nombre");
                    String nombre = s.next();

                    //Creamos un boolean y un int para la opcion de la raza
                    boolean elegir;
                    int opraza;
                    //Hacemos lo siguiente mientras no haya elegido un numero de la lista
                    do {
                        elegir = false;
                        System.out.println("Elige la raza");
                        //Muestra la lista de razas
                        mostrarRazas();
                        opraza = s.nextInt();
                        s.nextLine();

                        //Comprobamos si la opcion es valida
                        if (opraza < 0 || opraza >= creacion.getRazas().size()) {
                            System.out.println("Elige un número de la lista");
                            System.out.println("-------------------------");
                        } else {
                            elegir = true;
                        }
                    } while(!elegir);

                    //Hacemos lo mismo con la opcion de la clase
                    int opclase;
                    do {
                        elegir = false;
                        System.out.println("Elige la clase");
                        //Mostramos la lista de clases
                        mostrarClases();
                        opclase = s.nextInt();
                        s.nextLine();

                        //Comprobamos si la opcion es valida
                        if (opclase < 0 || opclase >= creacion.getClases().size()) {
                            System.out.println("Elige un número de la lista");
                            System.out.println("-------------------------");
                        } else {
                            elegir = true;
                        }
                    } while(!elegir);

                    //Llamamos a la funcion crearPersonaje y le pasamos los parametros indicados
                    creacion.crearPersonaje(nombre, opclase, opraza);

                    //Imprimimos el nombre, clase y raza del personaje creado
                    System.out.println("PERSONAJE CREADO");
                    System.out.println(creacion.getPersonajes().getLast().getNombre() + ": " + creacion.getPersonajes().getLast().getRaza().getClass().getSimpleName() + " " + creacion.getPersonajes().getLast().getClase().getClass().getSimpleName());
                    break;

                //Caso 0 salimos
                case 0:
                    terminar = true;
                    break;
                //Caso default volvemos a mostrar el menu
                default:
                    break;
            }

        } while(!terminar);
    }
}
