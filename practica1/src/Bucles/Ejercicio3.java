package Bucles;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int primero = s.nextInt();
        int segundo = s.nextInt();
        int tercero = s.nextInt();

        if(primero < segundo && segundo > tercero) {
            System.out.println(segundo);
            if(primero < tercero) {
                System.out.println(tercero);
                System.out.println(primero);
            } else {
                System.out.println(primero);
                System.out.println(tercero);
            }
        }
        if(primero > segundo && primero > tercero) {
           System.out.println(primero);
           if(segundo < tercero) {
               System.out.println(tercero);
               System.out.println(segundo);
           } else {
               System.out.println(segundo);
               System.out.println(tercero);
           }
        }
        if(primero < tercero && tercero > segundo) {
            System.out.println(tercero);
            if(primero < segundo) {
                System.out.println(segundo);
                System.out.println(primero);
            } else {
                System.out.println(primero);
                System.out.println(segundo);
            }
        }
    }
}
