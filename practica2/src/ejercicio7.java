import java.util.Scanner;

public class ejercicio7 {
    //Programa Java que llene un array con 10 números enteros que se leen por teclado
    //A continuación calcula y muestra la media de los valores positivos y la de los valores negativos del array.
    public static void main(String[] args) {
        //Programa Java que llene un array con 10 números enteros que se leen por teclado
        Scanner s = new Scanner(System.in);
        int[] x = new int[10];
        int sumaP = 0;
        int sumaN = 0;
        int contadorP = 0;
        int contadorN = 0;

        for(int i=0; i<10; i++) {
            System.out.println("Di un valor");
            x[i] = s.nextInt();
        }
        //A continuación calcula y muestra la media de los valores positivos y la de los valores negativos del array.

        for(int i=0; i<10; i++) {
            if(x[i]>=0) {
                sumaP += x[i];
                contadorP++;
            }
        }
        double mediaP = (double) sumaP / (double) contadorP;
        System.out.println("La media de los valores positivos es "+mediaP);

        for(int k = 0; k<10; k++) {
            if (x[k]<0) {
                sumaN += x[k];
                contadorN++;
            }
        }
        double mediaN = (double) sumaN / (double) contadorN;
        System.out.println("La media de los valorse negativos es "+mediaN);

    }
}
