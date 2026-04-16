package rpg.ui;

import rpg.dao.CiudadesDAO;
import rpg.dao.PersonajeDAO;
import rpg.logic.GestionMundo;
import rpg.logic.MotorCombate;
import rpg.model.Ciudades;
import rpg.model.Personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private PersonajeDAO personajeDAO;
    private GestionMundo gestionMundo;
    private Scanner s = new Scanner(System.in);
    private MotorCombate motorCombate;

    public Menu() {

        gestionMundo = new GestionMundo();
        motorCombate = new MotorCombate();
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
            System.out.println("4.- Cobrar Impuestos");
            System.out.println("5.- Equipar habilidades personaje");
            System.out.println("6.- Combate");
            System.out.println("7.- Personajes más Ricos");
            System.out.println("8.- Censo de Clases");
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
                case 4:
                    gestionMundo.cobroImpuestos(menuCobroImpuestos());
                    break;
                case 5:
                    gestionMundo.equiparHabilidades();
                    break;
                case 6:
                    List<Personajes> personajes = gestionMundo.getPersonajes();

                    for (Personajes p : personajes) {
                        System.out.println("ID: " + p.getIdPersonaje() + " - Nombre: " + p.getNombre());
                    }
                    System.out.println("Elige al primer personaje");
                    Personajes p1 = elegirPersonaje();
                    System.out.println("Elige al segundo personaje");
                    Personajes p2 = elegirPersonaje();
                    motorCombate.combate(p1, p2);
                    break;
                case 7:
                    gestionMundo.jugadoresRicos();
                    break;
                case 8:
                    gestionMundo.censo();
                    break;
                case 0:
                    salir = true;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while(!salir);
    }

    public List<Personajes> menuCobroImpuestos() {
        List<Ciudades> ciudades = gestionMundo.getCiudades();
        List<Personajes> personajes = gestionMundo.getPersonajes();
        List<Personajes> seleccionados = new ArrayList<>();

        System.out.println("De que ciudad elegir los personajes?");

        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println("ID: "+ciudades.get(i).getIdCiudades()+" - Nombre: "+ciudades.get(i).getNombre()+" - Nivel minimo: "+ciudades.get(i).getNivel_minimo_acceso());
        }

        boolean idCExiste = false;
        Ciudades ciudad = null;
        while(!idCExiste) {
            System.out.println("ID de la ciudad a elegir");
            int id = s.nextInt();

            for (Ciudades c : ciudades) {
                if (c.getIdCiudades() == id) {
                    ciudad = c;
                    break;
                }
            }

            if (ciudad == null) {
                System.out.println("Esa id no existe");
            } else {
                idCExiste = true;
            }
        }

        for (Personajes p : personajes) {
            if(p.getCiudad() != null && p.getCiudad().getIdCiudades() == ciudad.getIdCiudades()) {
                seleccionados.add(p);
            }
        }

        return seleccionados;
    }

    public Personajes elegirPersonaje() {
        List<Personajes> personajes = gestionMundo.getPersonajes();
        boolean correcto = false;
        Personajes seleccionado = null;
        while (!correcto) {
            System.out.println("Elige al personaje por id:");
            int id = s.nextInt();

            for (Personajes p : personajes) {
                if (p.getIdPersonaje() == id) {
                    seleccionado = p;
                    correcto = true;
                }
            }

            if (seleccionado == null) {
                System.out.println("Esa id no existe");
            }
        }

        return seleccionado;
    }
}
