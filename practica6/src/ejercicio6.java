import java.util.HashSet;

public class ejercicio6 {
    public static void main(String[] args) {
        HashSet<String> nombresVillanos = new HashSet<>();

        nombresVillanos.add("Goku Black");
        nombresVillanos.add("Negreira");
        nombresVillanos.add("Morgoth");
        nombresVillanos.add("Papa pitufo");
        nombresVillanos.add("Morgoth");
        nombresVillanos.add("Sauron");

        if(nombresVillanos.contains("Sauron")) {
            System.out.println("Sauron ha sido derrotado");
            nombresVillanos.remove("Sauron");
        }

    }
}
