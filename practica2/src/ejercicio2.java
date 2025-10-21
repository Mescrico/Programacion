import java.util.Scanner;

public class ejercicio2 {
    //Muestra por pantalla todos los elementos de un array
    //de números enteros separados por un espacio
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] x = {1,2,3,4,5};

        for(int i=0; i<5; i++) {
            System.out.print(x[i]+" ");
        }

    }
}
