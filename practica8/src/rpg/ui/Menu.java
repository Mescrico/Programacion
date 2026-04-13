package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.logic.GestionMundo;

import java.util.Scanner;

public class Menu {
    private PersonajeDAO personajeDAO;
    private GestionMundo gestionMundo;

    public Menu() {

        gestionMundo = new GestionMundo();
        menu();

    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("MENÚ");
            System.out.println("1.- Crear Personaje");
            System.out.println("2.- Viajar de Ciudad");
            System.out.println("3.- Comprar Items");
            System.out.println("----------------------");
            System.out.println("Selecciona una opcion");
            int opcion = s.nextInt();

            switch (opcion) {
                case 1:
                    gestionMundo.crearPersonaje();
                    break;
                case 2:
                    gestionMundo.viajarDeCiudad();
                    break;
                case 3:
                    gestionMundo.comprarItems();
                    break;
                case 0:
                    salir = true;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while(!salir);

    }
}
