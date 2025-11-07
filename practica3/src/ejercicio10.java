import java.util.Scanner;

public class ejercicio10 {
    //Realiza el juego de las tres en raya.

    //Creamos la funcion que muestre la mesa
    public static void mesa(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                //Si la casilla vale 7 (que es el que puesto como casilla vacia) printea un -
                if (tablero[i][j] == 7) {
                    System.out.print("- ");
                }
                //Si la casilla vale 1 printea la X
                if (tablero[i][j] == 1) {
                    System.out.print("X ");
                }
                //Si la casilla vale 2 printea el O
                if (tablero[i][j] == 2) {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    //Creamos la funcion que nos diga si el tablero esta lleno o no
    public static boolean lleno(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                //Si hay alguna casilla que valga 7 (casilla vacia) entonces devuelve falso
                if(tablero[i][j] == 7){
                    return false;
                }
            }
        }
        //Si no encuentra devuelve verdadero
        return true;
    }

    //Creamos la funcion que nos diga si ha acabado la partida
    public static boolean acabar(int[][] tablero) {
        //Creamos las variables de sumas de filas, columnas y las dos diagonales
        int sumaF = 0;
        int sumaC = 0;
        int sumaD1 = 0;
        int sumaD2 = 0;

        //Creamos el bucle para ir comprobando casilla por casilla
        for (int i = 0; i < tablero.length; i++) {
            //Reiniciamos la variable de fila para cada fila
            sumaF = 0;
            for (int j = 0; j < tablero[i].length; j++) {
                //Si el primer numero de una fila es igual al segundo y este es igual al tercero y no hay ningun 7 entonces
                if(tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][j] != 7) {
                    //Se suma a sumaF
                    sumaF += tablero[i][j];
                }
                //Si el primer numero de una columna es igual al segundo y este es igual al tercero y no hay ningun 7 entonces
                if(tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j] && tablero[i][j] != 7) {
                    //Se suma a sumaC
                    sumaC += tablero[i][j];
                }
                //Si el primer numero de la diagonal de la izquierda es igual al medio y este es igual al de abajo a la derecha y no hay ningun 7 entonces
                if(tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[1][1] != 7 ) {
                    //Se suma a sumaD!
                    sumaD1 = tablero[0][0] + tablero[1][1] + tablero[2][2];
                }
                //Si el primer numero de la diagonal de la derecha es igual al medio y este es igual al de abajo a la izquierda y no hay ningun 7 entonces
                if(tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[1][1] != 7) {
                    //Se suma a sumaD2
                    sumaD2 = tablero[0][2] + tablero[1][1] + tablero[2][0];
                }
                //Si todas las sumas entre si dan 0 (que como he puesto que solo se sumen si los 3 numeros son iguales para el empate va a valer 0) y el tablero esta lleno entonces
                if(sumaF + sumaC + sumaD1 + sumaD2 == 0 && lleno(tablero)) {
                    //Printea empate
                    System.out.println("Empate");
                    //Returnea verdadero para terminar el juego
                    return true;
                }
            }

            //Si cualquier variable de suma da 3 entonces
            if(sumaF == 3 || sumaC == 3 || sumaD1 == 3 || sumaD2 == 3) {
                //Printea que ganan las x
                System.out.println("Ganan las X");
                //Returnea verdadero para terminar el juego
                return true;
            }

            //Si cualquier variable de suma da 6 entonces
            if(sumaF == 6 || sumaC == 6 || sumaD1 == 6 || sumaD2 == 6) {
                //Printea que ganan los o
                System.out.println("Ganan los O");
                //Returnea verdadero para terminar el juego
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Creamos el tablero 3x3
        int[][] tablero = new int[3][3];
        //Creamos el bucle para colocar a cada casilla el valor de 7, que será la casilla vacia
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 7;
            }
        }

        //Printeamos que x es 1 y o es 2
        System.out.println("X = 1 / O = 2");
        //Printeamos la mesa
        mesa(tablero);

        //Creamos las variables y los booleanos
        int filas;
        int columnas;
        boolean turnox;
        boolean turnoo;
        boolean valido;

        //Creamos un do while para hacer esto mientras la partida no haya acabado
        do{
            //Al booleano de turno de x lo ponemos true y al turno de o falso
            turnox = true;
            turnoo = false;

            //Si turno de x es verdadero se hace lo siguiente
            if(turnox == true) {
                //Creamos un do while para hacer lo siguiente mientras el movimiento no sea valido
                do{
                    //Printeamos que es el turno de x y la fila y columna que elegira
                    System.out.println("Turno de las X");
                    System.out.println("Fila? 1-3");
                    filas = s.nextInt();
                    System.out.println("Columnas? 1-3");
                    columnas = s.nextInt();

                    //Si ha puesto alguna fila o columna mayor a 3 o menor a 1 le printeamos que es del 1 al 3 y el tablero
                    if(filas > 3 || columnas > 3 || filas < 1 || columnas < 1) {
                        System.out.println("Del 1 al 3");
                        mesa(tablero);
                        //Devolvemos valido como falso
                        valido = false;
                    }
                    //En caso contrario hace lo siguiente
                    else {
                        //Si en esa posicion, que he restado 1 para que vaya acorde al array, hay un valor que no sea 7 quiere decir que no es una posicion vacia
                        if (tablero[filas-1][columnas-1] != 7) {
                            //Printeamos que ya esta ocupada y mostramos el tablero
                            System.out.println("Posición ya ocupada");
                            mesa(tablero);
                            //Devolvemos valido como falso
                            valido = false;
                        }
                        //En caso contrario colocamos a esa posicion el valor de 1 y mostramos el tablero
                        else {
                            tablero[filas-1][columnas-1] = 1;
                            mesa(tablero);
                            //Devolvemos valido como verdadero
                            valido = true;
                            //Si la funcion acabar nos devuelve verdadero acabamos la partida
                            if(acabar(tablero)) return;
                        }
                    }
                } while(!valido);
            }

            //Ahora es el turno de o por lo que lo ponemos como true y al turno de x como falso
            turnox = false;
            turnoo = true;

            //Si el turno de o es verdadero hacemos lo siguiente
            if(turnoo == true) {
                //Creamos un do while para hacer lo siguiente mientras el movimiento no sea valido
                do{
                    //Printeamos que es el turno de o y la fila y columna que elegira
                    System.out.println("Turno de los O");
                    System.out.println("Fila? 1-3");
                    filas = s.nextInt();
                    System.out.println("Columnas? 1-3");
                    columnas = s.nextInt();

                    //Si ha puesto alguna fila o columna mayor a 3 o menor a 1 le printeamos que es del 1 al 3 y el tablero
                    if(filas > 3 || columnas > 3 || filas < 0 || columnas < 0) {
                        System.out.println("Del 1 al 3");
                        mesa(tablero);
                        //Devolvemos valido como falso
                        valido = false;
                    }
                    //En caso contrario hace lo siguiente
                    else {
                        //Si en esa posicion, que he restado 1 para que vaya acorde al array, hay un valor que no sea 7 quiere decir que no es una posicion vacia
                        if (tablero[filas-1][columnas-1] != 7) {
                            //Printeamos que ya esta ocupada y mostramos el tablero
                            System.out.println("Posición ya ocupada");
                            mesa(tablero);
                            //Devolvemos valido como falso
                            valido = false;
                        }
                        //En caso contrario colocamos a esa posicion el valor de 1 y mostramos el tablero
                        else {
                            tablero[filas-1][columnas-1] = 2;
                            mesa(tablero);
                            //Devolvemos valido como verdadero
                            valido = true;
                            //Si la funcion acabar nos devuelve verdadero acabamos la partida
                            if(acabar(tablero)) return;
                        }
                    }
                } while(!valido);
            }
        } while(!acabar(tablero));
    }
}
