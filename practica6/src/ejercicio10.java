import java.util.ArrayList;
import java.util.HashMap;

public class ejercicio10 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> miembrosGremio = new HashMap<>();

        ArrayList<String> alasdeFuego = new ArrayList<>();
        alasdeFuego.add("Mario");
        alasdeFuego.add("Óscar");
        alasdeFuego.add("Zxuno");

        miembrosGremio.put("Alas de fuego", alasdeFuego);

        ArrayList<String> sevenLuck = new ArrayList<>();
        sevenLuck.add("Sevy");
        sevenLuck.add("Venly");
        sevenLuck.add("Lucky");
        sevenLuck.add("Judas");

        miembrosGremio.put("Seven Luck", sevenLuck);

        for(String m : miembrosGremio.keySet()) {
            if(miembrosGremio.get(m).contains("Judas")) {
                System.out.println("Judas se encuentra en "+m);
                miembrosGremio.get(m).remove("Judas");
                System.out.println("Eliminado del gremio, miembros restantes: "+miembrosGremio.get(m));
            }
        }
    }
}
