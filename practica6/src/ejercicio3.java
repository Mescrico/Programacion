import java.util.HashMap;

public class ejercicio3 {
    public static void main(String[] args) {
        HashMap<String, Integer> cantidadOro = new HashMap<>();

        cantidadOro.put("Oscar",0);
        cantidadOro.put("Josemi", 5);
        cantidadOro.put("Mario", 10);

        System.out.println(cantidadOro.get("Josemi"));

    }
}
