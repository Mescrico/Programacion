import java.util.HashMap;

public class ejercicio9 {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> estadisticasJugador = new HashMap<>();

        HashMap<String, Integer> estadisticasGoku = new HashMap<>();
        estadisticasGoku.put("Fuerza", 15);
        estadisticasGoku.put("Destreza", 5);

        HashMap<String, Integer> estadisticasConan = new HashMap<>();
        estadisticasConan.put("Fuerza", 30);
        estadisticasConan.put("Destreza", 20);

        estadisticasJugador.put("Goku", estadisticasGoku);
        estadisticasJugador.put("Conan", estadisticasConan);

        for (String m : estadisticasJugador.keySet()) {
            if(m.equals("Conan")) {
                int fuerza = estadisticasConan.get("Fuerza") + 2;

                estadisticasConan.put("Fuerza", fuerza);
            }
        }

        System.out.println(estadisticasConan.get("Fuerza"));

    }
}
