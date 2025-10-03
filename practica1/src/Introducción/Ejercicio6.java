package Introducción;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        double y = s.nextDouble();

        double suma = (double) x+y;
        double resta = (double) x-y;
        double div = (double) x/y;
        double mult = (double) x*y;

        System.out.println("Suma: "+suma);
        System.out.println("Resta: "+resta);
        System.out.println("División: "+div);
        System.out.println("Multiplicación: "+mult);
    }
}
