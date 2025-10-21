import java.util.Arrays;
import java.util.Scanner;

public class ejercicio11 {
    //Escribe un programa java que invierta el orden de los valores de un array.
    //Por invertir el orden de los valores de un array, me refiero que el último pasa a ser el primero, el penúltimo el segundo y así sucesivamente
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Creamos el array de tamaño 6
        int[] numeros = {1,2,3,4,5,6};

        //Bucle para recorrer el array hasta la mitad
        for (int i = 0; i< numeros.length/2; i++) {
            //Definimos el inverso con la longitud del array, el número por el que va el bucle y le restamos el 1
            int inverso = numeros.length-i-1;
            //Guardamos el número actual del bucle
            int num = numeros[i];
            //Definimos que la posición del bucle actual es igual a la posición inversa
            numeros[i] = numeros[inverso];
            //Definimos que la posición inversa actual es igual al número actual del bucle
            numeros[inverso] = num;
        }
        System.out.println(Arrays.toString(numeros));
    }
}
