import java.util.Scanner;

public class ejercicio1 {

    //Crea un array de 10 posiciones de numeros con valores pedidos por teclado
    // Muestra por consola el indice y el valor al que corresponde
    public static void main(String[] args) {
        //Crea un array de 10 posiciones de numeros con valores pedidos por teclado
        Scanner s = new Scanner(System.in);
        int[] x = new int[10];
        for(int i=0; i<10; i++) {
            System.out.println("Introduce un valor");
            x[i] = s.nextInt();
        }

        // Muestra por consola el indice y el valor al que corresponde
        for(int i=0; i<10; i++) {
            System.out.println("El indice es "+i+" y corresponde al valor "x[i]);
        }

    }

}
