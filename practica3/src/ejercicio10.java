import java.util.Scanner;

public class ejercicio10 {
    //Realiza el juego de las tres en raya.

    public static void mesa(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 7) {
                    System.out.print("- ");
                } else {
                    System.out.print(tablero[i][j]+" ");
                }
            }
            System.out.println();

        }
    }
    public static boolean acabar(int[][] tablero) {
        int suma = 0;
        for (int i = 0; i < tablero.length; i++) {
            suma = 0;
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != 7) {
                    suma += tablero[i][j];
                }


            }
            if(suma == 3) {
                System.out.println("Ganan las X");
                return true;
            }

            if(suma == 6) {
                System.out.println("Ganan los O");
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[][] tablero = new int[3][3];
        int inicial = 7;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = inicial;
            }

        }

        System.out.println("X = 1 / O = 2");

        mesa(tablero);

        int filas;
        int columnas;
        boolean turnox = false;
        boolean turnoo = false;
        boolean valido = false;
        do{
            turnox = true;
            turnoo = false;
            if(turnox == true) {
                valido = false;
                do{
                    System.out.println("Turno de las X");
                    System.out.println("Fila? 1-3");
                    filas = s.nextInt();

                    System.out.println("Columnas? 1-3");
                    columnas = s.nextInt();
                    if(filas > 3 || columnas > 3 || filas < 1 || columnas < 1) {
                        System.out.println("Del 1 al 3");
                        mesa(tablero);
                        valido = false;
                    } else {
                        if (tablero[filas-1][columnas-1] != 7) {
                            System.out.println("Posición ya ocupada");
                            mesa(tablero);
                            valido = false;

                        } else {
                            tablero[filas-1][columnas-1] = 1;
                            mesa(tablero);
                            valido = true;
                            if(acabar(tablero)) break;

                        }
                    }
                } while(!valido);

            }
            turnox = false;
            turnoo = true;
            if(turnoo == true) {
                valido = false;
                do{
                    System.out.println("Turno de los O");
                    System.out.println("Fila? 1-3");
                    filas = s.nextInt();

                    System.out.println("Columnas? 1-3");
                    columnas = s.nextInt();
                    if(filas > 3 || columnas > 3 || filas < 0 || columnas < 0) {
                        System.out.println("Del 1 al 3");
                        mesa(tablero);
                        valido = false;
                    }

                    if (tablero[filas-1][columnas-1] != 7) {
                        System.out.println("Posición ya ocupada");
                        mesa(tablero);
                        valido = false;
                    } else {
                        tablero[filas-1][columnas-1] = 2;
                        mesa(tablero);
                        valido = true;
                        if(acabar(tablero)) break;
                    }
                } while(!valido);
            }

        } while(!acabar(tablero));



    }
}
