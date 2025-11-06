import java.util.Scanner;

public class ejercicio9 {
    //Escribe un programa que, dada una posición en un tablero de ajedrez, nos diga a qué
    //casillas podría saltar un caballo que se encuentra en esa posición. Como se indica en la
    //figura, el caballo se mueve siempre en forma de L. El tablero cuenta con 64 casillas. Las
    //columnas se indican con las letras de la “a” a la “h” y las filas se indican del 1 al 8
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Creamos el tablero 8x8
        String[][] tablero = new String[8][8];

        //Creamos las variables de letra y numero para nombrar cada casilla
        String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h"};
        String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //Hacemos el bucle que nombre a cada casilla
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                //La posicion del tablero actual es la letra de la iteracion j y el numero de la iteracion i
                tablero[i][j] = letras[j] + numeros[i];
                System.out.printf(tablero[i][j]+" ");
            }
            System.out.printf("%n");
        }

        //Pedimos que diga una posicion
        System.out.println("Donde quieres poner al caballo");
        String inicial = s.nextLine();

        //Creamos las variables con los movimientos que puede hacer el caballo y el booleano de encontrar
        int[][] movimientos = {{-1, -2}, {-2, -1}, {1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}};
        boolean encontrar = false;

        //Creamos el bucle para buscar los posibles movimientos
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                //Si la posicion que puso el usuario coincide con alguna posicion del tablero realizamos lo siguiente
                if(inicial.equals(tablero[i][j])) {
                    //Ponemos encontrar como true
                    encontrar = true;
                    System.out.println("Posibles movimientos en:");
                    //Creamos el bucle que vaya comparando las casillas del tablero
                    for (int k = 0; k < letras.length; k++) {
                        //Creamos las variables de nuevas filas y columnas tras sumarles las casillas de movimiento
                        int fila2 = i + movimientos[k][0];
                        int columna2 = j + movimientos[k][1];

                        //Si la nueva fila es mayor o igual que 0 y menor que la longitud del tablero y la nueva columna tambien realizamos lo siguiente
                        if(fila2 >= 0 && fila2 < tablero.length && columna2 >= 0 && columna2 < tablero.length) {
                            //Imprimimos la posicion mas un espaciado para que vaya concatenando
                            System.out.printf(tablero[fila2][columna2]+" ");
                        }
                    }
                }
            }
            //Si en la ultima iteracion sigue sin encontrar alguna posicion igual y encontrar es falso imprimimos que diga una posicion
            if(!encontrar && i == letras.length-1) {
                System.out.println("Pon una posicion que exista");
            }

        }

    }
}
