package services;

import handler.DatoInvalidoException;
import handler.RecursoNoEncontradoException;
import model.Ciudad;
import model.Item;
import model.Personaje;
import utils.JsonHelper;
import utils.LoggerCustom;
import utils.TxtHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    private List<Personaje> personajes;
    private List<Ciudad> ciudades;
    private List<Item> items;
    public GestionMundo() {

    }

    public void cargarTodo() {
        TxtHelper ciudadesR = new TxtHelper();
        ciudades = ciudadesR.cargarFichero();

        System.out.println("Ciudades leídas");
        LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Todas las ciudades se han leido");

        JsonHelper itemR = new JsonHelper();
        items = itemR.readList("practica7/Ficheros/items.json", Item.class);

        System.out.println("Items leidos");
        LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Todos los items se han leido");

        JsonHelper personajeR = new JsonHelper();
        personajes = personajeR.readList("practica7/Ficheros/personajes.json", Personaje.class);

        System.out.println("Personajes leidos");
        LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Todos los personajes se han leido");


        validar();

    }

    //Funcion validar para comprobar que existen los items que tienen los personajes al cargarlos
    public void validar() {
        //Creamos un hashmap para guardar cada item con su id
        HashMap<String, Item> idItems = new HashMap<>();
        for(Item item : items) {
            idItems.put(item.getId(), item);
        }

        //Para cada personaje se hace lo siguiente
        for (Personaje personaje : personajes) {
            try {
                //Para cada id del equipo del personaje
                for (String id : personaje.getEquipoIds()) {
                    //Si no esta esa id en el hashmap anterior es que no existe
                    if(!idItems.containsKey(id)) {
                        System.out.println("El item con id "+id+" del personaje "+personaje.getNombre()+" no existe, se ha eliminado");
                        //La borramos del personaje
                        personaje.getEquipoIds().remove(id);
                        throw new RecursoNoEncontradoException("El item con id "+id+" del personaje "+personaje.getNombre()+" no existe, se ha eliminado");
                    } else {
                        LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Item "+id+" del personaje "+personaje.getNombre()+" validado");
                    }
                }
            } catch (RecursoNoEncontradoException e ) {
                LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());

            }

        }
    }

    public void crearPersonaje() {
        Scanner s = new Scanner(System.in);
        JsonHelper json = new JsonHelper();
        System.out.println("Nombre:");
        String nombre = s.nextLine();
        System.out.println("Raza:");
        String raza = s.nextLine();
        System.out.println("Nivel:");
        int nivel = s.nextInt();
        s.nextLine();

        List<Item> catalogo = json.readList("practica7/Ficheros/items.json", Item.class);

        HashMap<String, Item> items = new HashMap<>();
        for (Item item : catalogo) {
            items.put(item.getId(), item);
        }

        ArrayList<String> equipo = new ArrayList<>();
        boolean acabar;
        String id;
        try {
            do {
                acabar = false;
                System.out.println("Item por id:");
                id = s.nextLine();

                if(items.containsKey(id)) {
                    equipo.add(id);
                    System.out.println("Item agregado, añadir otro? n para salir");
                    id = s.nextLine();

                    if(id.equals("n")) {
                        acabar = true;
                    }
                } else {
                    System.out.println("Esa id no existe");
                    throw new RecursoNoEncontradoException("El item con id "+id+" no existe");
                }
            } while(!acabar);
        } catch (RecursoNoEncontradoException e) {
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
        }



        try {
            if(nivel<0) {
                System.out.println("El nivel no puede ser negativo");
                throw new DatoInvalidoException("El nivel del personaje "+nombre+" negativo");
            }
            System.out.println("Personaje "+nombre+" creado");
            LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Se ha creado el personaje "+nombre);

            Personaje nuevo = new Personaje(nombre, raza, nivel, equipo);
            personajes.add(nuevo);
        } catch (DatoInvalidoException e) {
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
        }
    }

    public void guardarCambios() {
        JsonHelper guardar = new JsonHelper();

        guardar.writeList("practica7/Ficheros/personajes.json", personajes);
    }
}
