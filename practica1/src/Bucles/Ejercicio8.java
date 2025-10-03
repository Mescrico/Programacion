package Bucles;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x1 = s.nextInt();
        int x2 = s.nextInt();
        int x3 = s.nextInt();
        int x4 = s.nextInt();
        int x5 = s.nextInt();
        int x6 = s.nextInt();
        int x7 = s.nextInt();
        int x8 = s.nextInt();
        int x9 = s.nextInt();
        int x10 = s.nextInt();

        for (int i = 10; i >= 0; i--) {
            if (i == 10) {
                System.out.println(x10);
            } else if (i == 9) {
                System.out.println(x9);
            } else if (i == 8) {
                System.out.println(x8);
            } else if (i == 7) {
                System.out.println(x7);
            } else if (i == 6) {
                System.out.println(x6);
            } else if (i == 5) {
                System.out.println(x5);
            } else if (i == 4) {
                System.out.println(x4);
            } else if (i == 3) {
                System.out.println(x3);
            } else if (i == 2) {
                System.out.println(x2);
            } else if (i == 1) {
                System.out.println(x1);
            }
        }
    }
}