import java.util.Scanner;

public class ejercicio10 {
    //Realiza el juego de las tres en raya.

    public static void mesa(String [][] tablero, String inicial) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = inicial;
                System.out.printf(inicial+" ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[][] tablero = new String[3][3];

        String inicial = "-";

        mesa(tablero, inicial);

        int filas;
        int columnas;
        do{
            System.out.println("Turno de las X");
            System.out.println("Fila? 1-3");
             filas = s.nextInt();
            System.out.println("Columnas? 1-3");
            columnas = s.nextInt();
        } while(filas < 3 && columnas < 3);



    }
}
