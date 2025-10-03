package Bucles;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Di un número del día de la semana:");
        int numero = s.nextInt();

        for (int i = 1; i <= 7; i++ ) {
            if(numero == 1) {
                System.out.println("Lunes");
                break;
            }
            if(numero == 2) {
                System.out.println("Martes");
                break;
            }
            if(numero == 3) {
                System.out.println("Miércoles");
                break;
            }
            if(numero == 4) {
                System.out.println("Jueves");
                break;
            }
            if(numero == 5) {
                System.out.println("Viernes");
                break;
            }
            if(numero == 6) {
                System.out.println("Sábado");
                break;
            }
            if(numero == 7) {
                System.out.println("Domingo");
                break;
            }
            if(!(numero == 1 || numero == 2 || numero == 3 || numero == 4 || numero == 5 || numero == 6 || numero == 7)) {
                System.out.println("Número no valido");
                break;
            }
        }
    }
}
