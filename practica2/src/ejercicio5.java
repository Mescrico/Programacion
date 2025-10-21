import java.util.Scanner;

public class ejercicio5 {
    //Crea un array de números donde le indicamos por teclado el tamaño del array,
    //rellenaremos el array con números aleatorios entre 0 y 9,
    //al final muestra por pantalla el valor de cada posición y la suma de todos los valores.
    public static void main(String[] args) {
        //Crea un array de números donde le indicamos por teclado el tamaño del array,
        Scanner s = new Scanner(System.in);
        System.out.println("De cuanto quieres el array");
        int tamaño = s.nextInt();
        int[] numero = new int[tamaño];

        //rellenaremos el array con números aleatorios entre 0 y 9,
        for(int i = 0; i<numero.length; i++) {
            numero[i] = (int) (Math.random()*10);
            System.out.println("El array es de tamaño "+i+" y rellenado por el número "+numero[i]);

        }
    }
}
