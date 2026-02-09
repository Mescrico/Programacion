import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ejercicio14 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> mensajesJugador = new HashMap<>();

        ArrayList<String> mensajesMario = new ArrayList<>(List.of("hola", "adios", "hola"));
        ArrayList<String> mensajesOscar = new ArrayList<>(List.of("cantidubi", "mascazo", "eureka"));

        mensajesJugador.put("Mario", mensajesMario);
        mensajesJugador.put("Oscar", mensajesOscar);

        HashSet<String> jugadoresSilenciados = new HashSet<>();

        //Creo un HashSet para meter los mensajes de cada jugador, si hay alguno que se repite no se metera
        //Por lo que el tamaño sera menor de tres
        HashSet<String> mensajes = new HashSet<>();

        //Recorro cada jugador del HashMap
        for (String m: mensajesJugador.keySet()) {
            //Recorro los ultimos 3 mensajes de cada jugador
            for (int i = mensajesJugador.get(m).size()-1; i > mensajesJugador.get(m).size()-4; i--) {
                //Los meto en el HashSet, si se repite no se mete
                mensajes.add(mensajesJugador.get(m).get(i));
            }
            //Si mensaje no es 3 es porque tiene algun mensaje repetido
            if(mensajes.size() != 3) {
                //Se añade a la lista de silenciados y se le borra el historial de mensajes
                jugadoresSilenciados.add(m);
                mensajesJugador.get(m).clear();
            }
            //Borro el HashSet mensajes en cada iteracion
            mensajes.clear();
        }

        System.out.println("Jugadores silenciados: "+jugadoresSilenciados);
        System.out.println("Mensajes jugadores: "+mensajesJugador);
    }
}
