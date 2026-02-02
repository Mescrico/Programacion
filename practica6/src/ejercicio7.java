import java.util.ArrayList;
import java.util.HashMap;

public class ejercicio7 {
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

        miembrosGremio.put("Seven Luck", sevenLuck);

        for (String m : miembrosGremio.keySet()) {
            if(m.equals("Alas de fuego")) {
                System.out.println("Miembros de "+m+": "+ miembrosGremio.get(m));
            }
        }

    }
}
