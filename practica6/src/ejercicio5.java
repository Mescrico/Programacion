import java.util.HashMap;

public class ejercicio5 {
    public static void main(String[] args) {
        HashMap<String, Double> costoMana = new HashMap<>();

        costoMana.put("Espadas centelleantes", 55.0);
        costoMana.put("Salpicadura", 10.0);
        costoMana.put("Tortazo", 50.0);
        costoMana.put("Sombra mística", 70.0);
        costoMana.put("Ruleta rusa", 25.0);

        for (String m : costoMana.keySet()) {
            if(costoMana.get(m) > 50.0) {
                System.out.println("Hechizo: "+ m + " Mana: "+ costoMana.get(m));
            }
        }
    }
}
