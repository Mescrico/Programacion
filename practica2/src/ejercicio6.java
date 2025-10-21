import java.util.Scanner;

public class ejercicio6 {
    //Programa Java que guarda en un array 10 números enteros que se leen por teclado.
    //A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.
    public static void main(String[] args) {
        //Programa Java que guarda en un array 10 números enteros que se leen por teclado.
        Scanner s = new Scanner(System.in);
        int[] x = new int[10];
        int positivo = 0;
        int negativo = 0;
        int cero = 0;
        for(int i=0; i<10; i++) {
            System.out.println("Introduce un valor");
            x[i] = s.nextInt();
        }

        //A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.
        for(int i=0; i<x.length; i++) {
            if(x[i]>0) {
                positivo++;
            }
            if(x[i]<0) {
                negativo++;
            }
            if(x[i] == 0) {
                cero++;
            }
        }
        System.out.println("Hay "+positivo+" números positivos");
        System.out.println("Hay "+negativo+" números negativos");
        System.out.println("Hay "+cero+" números que son 0");
    }
}
