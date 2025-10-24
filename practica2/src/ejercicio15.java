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
            for (int k = j + 1; k <lista.size(); k++) {
                if(lista.get(j).equals(lista.get(k)) && j != k) {
                    lista.remove(k);
                    k--;
                }
            }
        }
        //Creamos un bucle que va a recorrer la lista
        for(int i = 0; i < lista.size() ; i++) {
            //Ponemos de minimo el valor i
            int minimo = i;
            //Creamos otro bucle para ver si en la posición j es mayor que minimo
            for( int j = i + 1; j < lista.size(); j++) {
                if(lista.get(minimo)>lista.get(j)) {
                    //Si lo es ahora minimo es j
                    minimo = j;
                }
            }

            //Si minimo no es i se ejecuta lo siguiente
            if(minimo != i) {
                //Guardamos el valor que hay en la posición de i en la lista
                int valor = lista.get(i);
                //Guardamos el valor que hay en la posición minima en la lista
                int valorminimo = lista.get(minimo);

                //Si minimo es mayor que i ejecuta lo siguiente
                if(minimo > i) {
                    //Elimina de la lista tanto la posición del minimo como la posición de i
                    lista.remove(minimo);
                    lista.remove(i);
                    //Agrega a la lista en la posición de i el valor minimo y en la posicion minima el valor de la posicion de i de ese momento
                    lista.add(i, valorminimo);
                    lista.add(minimo, valor);
                }
                //Si minimo es menor que i ejecuta lo siguiente
                if(minimo < i) {
                    //Elimina de la lista tanto la posición del minimo como la posición de i
                    lista.remove(i);
                    lista.remove(minimo);
                    //Agrega a la lista en la posición minimo el valor de la posición de i de ese momento y en la posición de i el valor minimo
                    lista.add(minimo, valor);
                    lista.add(i, valorminimo);
                }
            }
        }
        System.out.println(lista);
    }
}
