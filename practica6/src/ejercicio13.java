import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ejercicio13 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<HashSet<String>>> incursiones = new HashMap<>();

        HashSet<String> party1 = new HashSet<>(List.of("Mario", "Oscar", "Pedro"));
        HashSet<String> party2 = new HashSet<>(List.of("Mario", "Oscar"));
        HashSet<String> party3 = new HashSet<>(List.of("Pedro", "Mario"));

        ArrayList<HashSet<String>> grietaNegra = new ArrayList<>(List.of(party1, party2, party3));

        incursiones.put("Grieta Negra", grietaNegra);

        //Creo un HashMap de contador para guardar las veces que esta repetido cada jugador
        HashMap<String, Integer> contador = new HashMap<>();

        //Recorro todas las incursiones
        for (String m: incursiones.keySet()) {

            //Guardo la actual
            ArrayList<HashSet<String>> guardar = incursiones.get(m);

            //Recorro cada party de la incursion
            for (int i = 0; i < guardar.size(); i++) {
                //Guardo la actual
                HashSet<String> guardar2 = guardar.get(i);

                //Recorro cada jugador de la party
                for (String n: guardar2) {
                    //Guardo en el contador al jugador con un getordefault para poner 0 si es la primera vez que se guarda y se va sumando uno por cada vez que se repita
                    contador.put(n,contador.getOrDefault(n, 0)+1);
                }
            }
        }

        int numeromax = 0;
        String mvp = "maikel";

        //Recorro cada jugador del contador
        for (String m: contador.keySet()) {
            //Compruebo si supera al numeromax
            if(numeromax<contador.get(m)) {
                //Si lo supera actualizamos el numeromax y el mvp
                numeromax = contador.get(m);
                mvp = m;
            }
        }

        System.out.println("MVP: "+mvp+" con "+numeromax);
    }
}
