import java.util.ArrayList;

public class ejercicio1 {
    public static void main(String[] args) {
        ArrayList<String> registroCombate = new ArrayList<>();

        registroCombate.add("Orco derrotado");
        registroCombate.add("Poción usada");
        registroCombate.add("Hada capturada");
        registroCombate.add("Ataque esquivado");
        registroCombate.add("Huido con exito");

        System.out.println(registroCombate.get(2));
    }
}
