import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ejercicio15 {
    //Crea un programa que:
    //- Cree una lista de enteros (ArrayList<Integer>).
    //- Pida al usuario 10 números enteros y los añada a la lista.
    //- Elimine los valores duplicados manteniendo solo el primero que apareció.
    //- Ordene la lista de menor a mayor y la muestre por pantalla.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Creamos la lista de enteros
        ArrayList<Integer> lista = new ArrayList<>();

        //Pedimos los 10 números
        System.out.println("Di 10 números enteros");
        for (int i = 0; i <= 9; i++) {
            int numero = s.nextInt();
            lista.add(numero);
        }

        //Creamos 2 bucles para que vayan comparando posición por posición
        for(int j = 0; j <lista.size(); j++) {
            for (int k = 1; k <lista.size(); k++) {
                if(lista.get(j).equals(lista.get(k)) && j != k) {
                    lista.remove(k);
                    k--;
                }
            }
        }
        //Con este comando hacemos que se ordene de menor a mayor
        lista.sort(null);

        System.out.println(lista);
    }
}
