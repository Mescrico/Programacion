package Bucles;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("Di la hora");

            int hora = s.nextInt();

            if (hora >= 6 && hora <= 12) {
                System.out.println("Buenos días");
            } else if (hora >= 13 && hora <= 20) {
                System.out.println("Buenas tardes");
            } else if (hora >= 21 && hora <= 24) {
                System.out.println("Buenas noches");
            } else if (hora >= 0 && hora <= 5) {
                System.out.println("Buenas noches");
            } else {
                System.out.println("Número no válido");
                break;
            }
        }

    }
}
