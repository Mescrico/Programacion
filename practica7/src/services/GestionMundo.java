package services;

import model.Ciudad;
import model.Item;
import model.Personaje;
import utils.JsonHelper;
import utils.TxtHelper;

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
        personajes = personajeR.readList("practica7/Ficheros/items.json", Personaje.class);

    }

    public void crearPersonaje(List<String> idsItems) {
        Scanner s = new Scanner(System.in);
        JsonHelper json = new JsonHelper();
        System.out.println("Nombre:");
        String nombre = s.nextLine();
        System.out.println("Raza:");
        String raza = s.nextLine();


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

        if(noExisten.isEmpty()) {
            System.out.println("Todos los items existen");
        } else {
            System.out.println("Estos items no existen:");
            System.out.println(noExisten);
        }

        Personaje nuevo = new Personaje(nombre, raza, 0, existen);
        personajes.add(nuevo);
    }

    public void guardarCambios() {
        JsonHelper guardar = new JsonHelper();

        guardar.writeList("practica7/Ficheros/personajes.json", personajes);
    }
}
