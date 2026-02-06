import java.util.HashMap;
import java.util.Scanner;

public class ejercicio12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, HashMap<String, Boolean>> habilidadPersonaje = new HashMap<>();

        HashMap<String, Boolean> habilidadEnano = new HashMap<>();
        habilidadEnano.put("Golpe", true);

        HashMap<String, Boolean> habilidadPaladin = new HashMap<>();
        habilidadPaladin.put("Golpe Divino", false);
        habilidadPaladin.put("Enfoque", false);

        habilidadPersonaje.put("Enano", habilidadEnano);
        habilidadPersonaje.put("Paladin", habilidadPaladin);

        System.out.println("Elige que personaje eres");
        for (String m : habilidadPersonaje.keySet()) {
            System.out.println(m);
        }

        String personaje = s.nextLine();
        if(habilidadPersonaje.containsKey(personaje)) {
            HashMap<String, Boolean> habilidadElegido = habilidadPersonaje.get(personaje);

            boolean salir = false;
            boolean guardar = false;
            for (String m : habilidadElegido.keySet()) {
                System.out.println(m+": "+habilidadElegido.get(m));
            }

            do {
                guardar = habilidadElegido.containsValue(false); //Esto es para comprobar en cada iteracion si hay alguna habilidad del pj elegido que falte por desbloquear

                if(guardar == false) { //Si es false se pq todas las habilidades estan desbloqueadas
                    System.out.println("Todas las habilidades estan desbloqueadas");
                    salir = true;
                }

                if(guardar) {

                    System.out.println("Quieres desbloquear las siguientes habilidades?");
                    for (String m : habilidadElegido.keySet()) {

                        if(habilidadElegido.get(m) == false) {
                            System.out.println(m);
                        }
                    }

                    System.out.println("Pon el nombre de la habilidad a desbloquear");
                    String nombre = s.nextLine();

                    if(habilidadElegido.containsKey(nombre)) {
                        if(nombre.equals("Golpe Divino") && habilidadElegido.get("Enfoque") == false) {
                            System.out.println("Primero hay que desbloquear la habilidad enfoque");
                        } else {
                            habilidadElegido.put(nombre, true);
                            System.out.println("Se ha desbloqueado "+nombre);
                            for (String m : habilidadElegido.keySet()) {
                                System.out.println(m+": "+habilidadElegido.get(m));
                            }
                        }
                    } else {
                        System.out.println("No existe esa habilidad");
                    }

                }
            } while (!salir);

        } else {
            System.out.println("No existe ese personaje");
        }
    }
}
