package Introducción;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double pesetas = 166.39;
        double euros = s.nextDouble();

        double resultado = pesetas*euros;

        System.out.println(euros+" euros a pesetas son: "+resultado+" pesetas");
    }
}
