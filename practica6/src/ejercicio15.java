import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ejercicio15 {
    public void procesarVenta(String item, HashMap<String, PriorityQueue<Puja>> pujaItems ) {
        if(pujaItems.containsKey(item)) {
            for (String m: pujaItems.keySet()) {
                if(m.equals(item)) {

                }
            }
        } else {
            System.out.println("No hay ese item");
        }
    }

    public static void main(String[] args) {
        HashMap<String, PriorityQueue<Puja>> pujaItems = new HashMap<>();

        PriorityQueue<Puja> pujaGuantesdeJesus = new PriorityQueue<>(Comparator.comparing(Puja::getCantidad).reversed());
        pujaGuantesdeJesus.add(new Puja(300.0,"Mario"));
        pujaGuantesdeJesus.add(new Puja(200.0,"Oscar"));
        pujaGuantesdeJesus.add(new Puja(500.0,"Josemi"));

        while (!pujaGuantesdeJesus.isEmpty()) {
            System.out.println(pujaGuantesdeJesus.poll());
        }

        System.out.println(pujaGuantesdeJesus);
        pujaItems.put("Guantes de Jesus", pujaGuantesdeJesus);

        HashMap<String, Double> saldoJugadores = new HashMap<>();
        saldoJugadores.put("Mario", 400.0);
        saldoJugadores.put("Oscar", 300.0);
        saldoJugadores.put("Josemi", 400.0);

    }
}
