import java.util.ArrayList;

public class ejercicio4 {
    public static void main(String[] args) {
        ArrayList<String> registroCombate = new ArrayList<>();

        registroCombate.add("Orco derrotado");
        registroCombate.add("Poción usada");
        registroCombate.add("Hada capturada");
        registroCombate.add("Ataque esquivado");
        registroCombate.add("Huido con exito");

        registroCombate.remove(0);
        registroCombate.add("Dragón avistado");

        System.out.println(registroCombate.getLast());

    }
}
