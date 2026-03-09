package services;

import handler.DatoInvalidoException;
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

        JsonHelper itemR = new JsonHelper();
        items = itemR.readList("practica7/Ficheros/items.json", Item.class);

        JsonHelper personajeR = new JsonHelper();
        personajes = personajeR.readList("practica7/Ficheros/personajes.json", Personaje.class);

        validar();

    }

    public void validar() {
        HashMap<String, Item> mapaItems = new HashMap<>();
        for(Item item : items) {
            mapaItems.put(item.getId(), item);
        }


        for (Personaje personaje : personajes) {
            ArrayList<Item> equipoPersonaje = new ArrayList<>();

            if(personaje.getEquipoIds() != null) {
                for (String id : personaje.getEquipoIds()) {
                    if(mapaItems.containsKey(id)) {
                        equipoPersonaje.add(mapaItems.get(id));
                    } else {
                        System.out.println("El item con id "+id+" no existe");
                    }
                }
            }

            personaje.setEquipo(equipoPersonaje);
        }
    }

    public void crearPersonaje(List<String> idsItems) {
        Scanner s = new Scanner(System.in);
        JsonHelper json = new JsonHelper();
        System.out.println("Nombre:");
        String nombre = s.nextLine();
        System.out.println("Raza:");
        String raza = s.nextLine();
        System.out.println("Nivel");
        int nivel = s.nextInt();

        List<Item> catalogo = json.readList("practica7/Ficheros/items.json", Item.class);

        HashMap<String, Item> items = new HashMap<>();
        for (Item item : catalogo) {
            items.put(item.getId(), item);
        }

        List<Item> existen = new ArrayList<>();

        ArrayList<String> noExisten = new ArrayList<>();

        for (String id : idsItems) {
            if(!items.containsKey(id)) {
                noExisten.add(id);
            } else {
                existen.add(items.get(id));
            }
        }

        ArrayList<String> equipoIDS = new ArrayList<>();
        for (int i = 0; i < existen.size(); i++) {
            equipoIDS.add(existen.get(i).getId());
        }

        System.out.println(existen);
        if(!noExisten.isEmpty()) {
            System.out.println();
            System.out.println(noExisten);
        }

        try {
            if(nivel<0) {
                throw new DatoInvalidoException("El nivel no puede ser negativo");
            }
            Personaje nuevo = new Personaje(nombre, raza, nivel, equipoIDS);
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
