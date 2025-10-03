package Introducción;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Di la base:");
        double base = s.nextDouble();

        System.out.println("Di la altura:");
        double altura = s.nextDouble();

        double resultado = base*altura;

        System.out.println("El área es: "+resultado);
    }
}
