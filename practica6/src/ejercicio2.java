import java.util.HashSet;

public class ejercicio2 {
    public static void main(String[] args) {
        HashSet<String> nombresVillanos = new HashSet<>();

        nombresVillanos.add("Goku Black");
        nombresVillanos.add("Negreira");
        nombresVillanos.add("Morgoth");
        nombresVillanos.add("Papa pitufo");
        nombresVillanos.add("Morgoth");

        System.out.println(nombresVillanos.size());

    }
}
