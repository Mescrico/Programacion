import java.util.Scanner;

public class ejercicio3 {
    //Crea un array que contenga 5 números.
    //Realiza un programa que te muestre por pantalla SOLO el más pequeño de ellos.
    public static void main(String[] args) {
        //Crea un array que contenga 5 números.
        Scanner s = new Scanner(System.in);
        int[] x = new int[5];
        System.out.println("Di los números");
        for(int i=0; i<5; i++) {
            x[i] = s.nextInt();

        }
        System.out.println("El número menor es: "+minimo(x));
    }

    public static int minimo(int[] menor) {
        //Realiza un programa que te muestre por pantalla SOLO el más pequeño de ellos.
        int min = Integer.MAX_VALUE;
        for(int i=0; i<menor.length; i++) {
            if (menor[i] < min) {
                min = menor[i];
            }
        }
        return min;
    }
}
