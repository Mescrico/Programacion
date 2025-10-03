package Introducción;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Decir día de la semana:");
        String dia = s.nextLine();

        String lunes = "lunes";
        String martes = "martes";
        String miercoles = "miercoles";
        String jueves = "jueves";
        String viernes = "viernes";

        if (dia.equals(lunes)) {
            System.out.println("El "+lunes+" toca Digitalización");
        }
        if (dia.equals(martes)) {
            System.out.println("El "+martes+" toca Sistemas informáticos");
        }
        if (dia.equals(miercoles)) {
            System.out.println("El "+miercoles+" toca Sistemas informáticos");
        }
        if (dia.equals(jueves)) {
            System.out.println("El "+jueves+" toca Sistemas informáticos");
        }
        if (dia.equals(viernes)) {
            System.out.println("El " +viernes+ " toca Programación");
        }
        if (!dia.equals(lunes) || !dia.equals(martes) || !dia.equals(miercoles) || !dia.equals(jueves) || !dia.equals(viernes)) {
            System.out.println("Ese día no existe o has escrito mal el día, recuerda escribir en minuscula y sin tilde");
        }
    }
}
