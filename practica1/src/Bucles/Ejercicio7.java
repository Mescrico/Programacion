package Bucles;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Indica el número a multiplicar hasta el 10");
        int numero = s.nextInt();
        for(int i = 0; i <= 10; i++) {
            System.out.println(numero+" x "+i+" = "+numero*i);
        }
    }
}
