package rpg.ui;

import rpg.dao.PersonajeDAO;

import java.util.Scanner;

public class Menu {
    private PersonajeDAO personajeDAO;

    public Menu() {
        personajeDAO = new PersonajeDAO();

        menu();

    }

    public void menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("MENÚ");
        System.out.println("1.- Crear Personaje");
        System.out.println("2.- Viajar de Ciudad");
        System.out.println("----------------------");
        System.out.println("Selecciona una opcion");
        int opcion = s.nextInt();

        switch (opcion) {
            case 1:
                personajeDAO.crearPersonaje();
                break;
            case 2:
                personajeDAO.viajarDeCiudad();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
}
