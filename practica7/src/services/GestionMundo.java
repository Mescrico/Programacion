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
import java.util.*;

public class GestionMundo {
    Scanner s = new Scanner(System.in);
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

        try {

        } catch (RuntimeException e) {
            System.out.println("a");
        } catch (Exception e) {
            System.out.println("b");
        }

        System.out.println("Personajes leidos");
        LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Todos los personajes se han leido");


        validar();

    }

    //Funcion validar para comprobar que existen los items que tienen los personajes al cargarlos
    public void validar() {
        //Creamos un hashmap para guardar cada item con su id
        HashMap<String, Item> idItems = new HashMap<>();
        HashMap<String, Ciudad> nombreCiudades = new HashMap<>();
        for(Item item : items) {
            idItems.put(item.getId(), item);
        }

        for(Ciudad ciudad : ciudades) {
            nombreCiudades.put(ciudad.getNombre(), ciudad);
        }

        //Para cada personaje se hace lo siguiente
        for (Personaje personaje : personajes) {
            try {
                JsonHelper guardar = new JsonHelper();
                //Para cada id del equipo del personaje
                for (String id : personaje.getEquipoIds()) {
                    //Si no esta esa id en el hashmap anterior es que no existe
                    if(!idItems.containsKey(id)) {
                        System.out.println("El item con id "+id+" del personaje "+personaje.getNombre()+" no existe, se ha eliminado");
                        //La borramos del personaje
                        personaje.getEquipoIds().remove(id);
                        guardar.writeList("practica7/Ficheros/personajes.json", personajes);
                        throw new RecursoNoEncontradoException("El item con id "+id+" del personaje "+personaje.getNombre()+" no existe, se ha eliminado");
                    } else {
                        LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Item "+id+" del personaje "+personaje.getNombre()+" validado");
                    }

                }
            } catch (RecursoNoEncontradoException e ) {
                LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());

            }
        }

        HashSet<Personaje> borrar = new HashSet<>();

        for (Personaje personaje : personajes) {
            try {

                if(personaje.getRaza().equalsIgnoreCase("humano")) {
                    if(nombreCiudades.get(personaje.getCiudad()).getClima().equalsIgnoreCase("Desertico")){
                        borrar.add(personaje);
                        System.out.println("Personaje "+personaje.getNombre()+" se ha eliminado de la lista");
                        throw new DatoInvalidoException("El personaje "+personaje.getNombre()+" al ser humano no puede estar en una ciudad con clima "+nombreCiudades.get(personaje.getCiudad()).getClima());
                    }

                }

                if(personaje.getEquipoIds().contains("H01")) {
                    if(nombreCiudades.get(personaje.getCiudad()).getClima().equalsIgnoreCase("volcanico")){
                        borrar.add(personaje);
                        System.out.println("Personaje "+personaje.getNombre()+" se ha eliminado de la lista");
                        throw new DatoInvalidoException("El personaje "+personaje.getNombre()+" no puede tener un objeto Hielo - "+idItems.get("H01").getId()+" - en una ciudad con clima "+nombreCiudades.get(personaje.getCiudad()).getClima());

                    }
                }
            } catch (DatoInvalidoException e) {
                LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
            }
        }

        for(Personaje personaje : borrar) {
            personajes.remove(personaje);
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

        Boolean valido = false;
        int opcion;
        do {
            valido = false;
            System.out.println("Ciudad:");
            for (int i = 0; i < ciudades.size(); i++) {
                System.out.println(i+"- "+ciudades.get(i));
            }
            opcion = s.nextInt();

            if(opcion < 0 || opcion > ciudades.size()) {
                System.out.println("No es valido");
            } else {
                valido = true;
            }
        } while (!valido);


        String ciudad = ciudades.get(opcion).getNombre();

        try {
            if(nivel<0) {
                System.out.println("El nivel no puede ser negativo");
                throw new DatoInvalidoException("El nivel del personaje "+nombre+" negativo");
            }
            System.out.println("Personaje "+nombre+" creado");
            LoggerCustom.log("["+ LocalDateTime.now()+"] INFO: Se ha creado el personaje "+nombre);

            Personaje nuevo = new Personaje(nombre, raza, nivel, equipo, ciudad);
            personajes.add(nuevo);
        } catch (DatoInvalidoException e) {
            LoggerCustom.log("["+ LocalDateTime.now()+"] ERROR: "+e.getClass().getSimpleName()+" - "+e.getMessage());
        }
    }

    public void guardarCambios() {
        JsonHelper guardar = new JsonHelper();

        guardar.writeList("practica7/Ficheros/personajes.json", personajes);
    }

    public void menu() {
        boolean salir = false;
        do {
            System.out.println("Menu");
            System.out.println("1- Crear personaje");
            System.out.println("2- Guardar cambios");
            System.out.println("3- Listar personajes");
            System.out.println("4- Listar ciudades");
            System.out.println("5- Listar items");
            System.out.println("0- Salir");

            int opcion = s.nextInt();
            switch (opcion) {
                case 1: crearPersonaje();
                    break;
                case 2: guardarCambios();
                    break;
                case 3:
                    for (int i = 0; i < personajes.size(); i++) {
                        System.out.println(i+1+"- "+personajes.get(i).getNombre()+" - "+personajes.get(i).getRaza()+" - "+personajes.get(i).getEquipoIds()+" - "+personajes.get(i).getCiudad());
                    }
                    break;
                case 4:
                    for (int i = 0; i < ciudades.size(); i++) {
                        System.out.println(i+1+"- "+ciudades.get(i).getNombre());
                    }
                    break;
                case 5:
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(i+1+"- "+items.get(i).getNombre()+" - "+items.get(i).getId());
                    }
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Pon una opcion valida");
                    break;
            }
        } while (!salir);

    }
}
