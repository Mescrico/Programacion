import java.util.Scanner;

public class ejercicio12 {
    //Realiza un programa donde le pidas al usuario SOLO el número del dni y el programa te devuelva la letra
    //Para calcular la letra solo tienes que dividir el número del DNI entre 23
    //El resto de esta división se corresponde con la posición de la letra en el abecedario
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Escribimos el DNI por teclado
        System.out.println("Introduce tu DNI (Recuerda 8 números)");
        int dni = s.nextInt();
        //Calculamos el resto
        int numero = dni % 23;
        //Definimos el array con el orden
        String[] letra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        //Se ordena el resto por la letra que le corresponde
        String real = letra[numero];

        System.out.println("La letra del DNI "+dni+" es "+real);

    }
}
