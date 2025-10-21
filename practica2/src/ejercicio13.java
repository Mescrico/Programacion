import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio13 {
    //Crea un programa que:
    //Cree una lista de enteros (ArrayList<Integer>).
    //Pida números por teclado hasta que el usuario introduzca un número negativo (ese no se añade).
    //Muestre por pantalla todos los números de la lista y la suma total de los mismos.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Crear una lista de enteros
        ArrayList<Integer> lista = new ArrayList<>();

        int numero;
        //Hacemos el bucle para que pida por teclado el número
        do{
            System.out.println("Di el número (negativo = fin)");
            numero = s.nextInt();
            //Si es menor que 0 no se añade
            if (numero >= 0) {
                lista.add(numero);
            }
        } while (numero >= 0);

        int suma = 0;
        //Hacemos el bucle para sumar cada numero de la lista
        for (int i = 0; i <lista.size(); i++) {
            suma = suma + lista.get(i);
        }


        System.out.println(lista);
        System.out.println(suma);


    }
}
