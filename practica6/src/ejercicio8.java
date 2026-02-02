import java.util.HashMap;
import java.util.HashSet;

public class ejercicio8 {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> lootMonstruo = new HashMap<>();

        HashSet<String> babuino = new HashSet<>();
        babuino.add("Piel");
        babuino.add("Carne");
        babuino.add("Platanos");

        HashSet<String> trasgo = new HashSet<>();
        trasgo.add("Espada Oxidada");
        trasgo.add("Sangre");
        trasgo.add("Espada Oxidada");

        lootMonstruo.put("Babuino", babuino);
        lootMonstruo.put("Trasgo", trasgo);

        for (String m : lootMonstruo.keySet()) {
            if(m.equals("Trasgo")) {
                System.out.println(lootMonstruo.get(m));
            }
        }

    }
}
