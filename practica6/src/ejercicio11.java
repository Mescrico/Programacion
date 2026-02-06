import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ejercicio11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Double> preciosItems = new HashMap<>();
        HashMap<String, ArrayList<String>> stockCiudades = new HashMap<>();

        preciosItems.put("Craneo", 20.0);
        preciosItems.put("Espada sagrada", 500.0);
        preciosItems.put("Pata de conejo", 10.0);
        preciosItems.put("Hacha", 200.0);
        preciosItems.put("Armadura", 100.0);
        preciosItems.put("Anillo", 75.0);
        preciosItems.put("Pendiente", 50.0);
        preciosItems.put("Hierbas", 25.0);
        preciosItems.put("Madera", 30.0);

        ArrayList<String> stockArcos = new ArrayList<>();
        stockArcos.add("Craneo");
        stockArcos.add("Hierbas");
        stockArcos.add("Madera");
        stockArcos.add("Hacha");
        stockArcos.add("Anillo");
        stockArcos.add("Armadura");

        ArrayList<String> stockJerez = new ArrayList<>();
        stockJerez.add("Espada sagrada");
        stockJerez.add("Pendiente");
        stockJerez.add("Pata de conejo");


        stockCiudades.put("Arcos", stockArcos);
        stockCiudades.put("Jerez", stockJerez);

        System.out.println("Ciudades disponibles:");
        for (String m : stockCiudades.keySet()) {
            System.out.println(m);
        }
        System.out.println("Selecciona una ciudad");
        String nombre = s.nextLine();

        if (stockCiudades.containsKey(nombre)) {
            ArrayList<String> stockNombre = stockCiudades.get(nombre);

            for (String m : stockNombre) {
                if (preciosItems.containsKey(m)) {
                    if (stockNombre.size() > 5) {
                        System.out.println(m + ": " + ((preciosItems.get(m) * 0.10) + preciosItems.get(m)));
                    } else {
                        System.out.println(m + ": " + preciosItems.get(m));
                    }
                }

            }
        } else {
            System.out.println("No hay ninguna ciudad con ese nombre");
        }
    }
}
