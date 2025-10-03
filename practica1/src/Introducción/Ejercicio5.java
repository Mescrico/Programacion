package Introducción;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double euros = 0.006;
        double pesetas = s.nextDouble();

        double resultado = euros*pesetas;

        System.out.println(pesetas+" pesetas a euros son: "+resultado+" euros");
    }
}
