import java.util.Scanner;

public class ejercicio8 {

    //Realizar el juego de la “Búsqueda del tesoro” donde si te acercas al tesoro te va avisando de
    //que hay un tesoro cerca pero agregando que tenemos dos posibles tesoros en el juego y
    //uno de ellos es un impostor

    //Creamos la funcion de tablero para que nos lo muestre
    public static void tablero(int[][] mesa) {
        //Creamos el bucle que ponga los simbolos a las casillas
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                //Si es casilla normal, tesoro verdadero (1) o tesoro falso (2) imprime X
                if(mesa[i][j] == 0 || mesa[i][j] == 1 || mesa[i][j] == 2) {
                    System.out.printf("%-5s", "X");
                }
                //Si es la casilla por la que te mueves imprime el emoji
                if(mesa[i][j] == 3) {
                    System.out.printf("%-5s", "\uD83D\uDEB6");
                }

            }
            System.out.printf("%n");
        }
    }

    //Creamos la funcion de acabar el juego
    public static boolean acabar(int[][] mesa, int destino) {
        //Creamos el bucle para generar de nuevo las posiciones
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                //Si a donde vamos es igual a 1 hemos ganado
                if(destino == 1) {
                    System.out.println("\uD83E\uDE99 Ganaste \uD83D\uDC4F");
                    return true;
                }
                //si a donde vamos es igual a 2 hemos perdido
                if(destino == 2) {
                    System.out.println("\uD83D\uDC80 Perdiste \uD83D\uDE02");
                    return true;
                }
            }

        }
        //Mientras no lleguemos a esas condiciones es falso
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Creamos el tablero
        int[][] mesa = new int[5][5];
        //Creamos las variables que generaran la posicion aleatoria que vale 1
        int x = (int) (Math.random() * 5);
        int y = (int) (Math.random() * 5);
        mesa[x][y] = 1;
        //Generamos otras posiciones para la que vale 2 mientras esas mismas sean las mismas que la que vale 1
        do {
            x = (int) (Math.random() * 5);
            y = (int) (Math.random() * 5);
        } while (mesa[x][y] == 1);
        mesa[x][y] = 2;

        //Predefinimos nuestra posicion actual como la 0,0
        int posactualx = 0;
        int posactualy = 0;
        //Si en esa posicion esta el tesoro falso o verdadero lo cambiamos
        if(mesa[posactualx][posactualy] == 1 || mesa[posactualx][posactualy] == 2) {
            //Si es el verdadero lo cambia de lugar
            if(mesa[posactualx][posactualy] == 1) {
                //Lo vamos cambiamos de lugar siempre que este en la misma posicion que el falso
                do{
                    x = (int) (Math.random() * 5);
                    y = (int) (Math.random() * 5);
                    mesa[x][y] = 1;
                } while (mesa[x][y] == 2);

            }
            //Si es el falso lo cambia de lugar
            if(mesa[posactualx][posactualy] == 2) {
                //Lo vamos cambiando de lugar siempre que este en la misma posicion que el verdadero
                do{
                    x = (int) (Math.random() * 5);
                    y = (int) (Math.random() * 5);
                    mesa[x][y] = 2;
                } while (mesa[x][y] == 1);
            }
        }
        //Ponemos que en la posicion 0,0 el emoji
        mesa[posactualx][posactualy] = 3;

        //Creamos las variables con las posibles direcciones que puede tomar incluidas las diagonales
        int[] direccionx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] direcciony = {-1, 0, 1, -1, 1, -1, 0, 1};

        //Creamos el bucle que nos diga si estamos cerca de algun tesoro al inicio
        for (int i = 0; i < direccionx.length; i++) {
            //Creamos las variables de cercania, son la posicion actual mas la direccion posible que se hara en cada iteracion
            int cercax = posactualx + direccionx[i];
            int cercay = posactualy + direcciony[i];

            //Si el valor de esas variables es mayor y menor que el tamaño del array mesa hacemos lo siguiente
            //Esto es para que no se vaya out of index
            if (cercax >= 0 && cercax < mesa.length && cercay >= 0 && cercay < mesa[0].length) {
                //Pondremos el mensaje de cerca siempre que en esas posiciones sean el tesoro verdadero o falso
                if (mesa[cercax][cercay] == 1 || mesa[cercax][cercay] == 2) {
                    System.out.println("Cerca");
                    break;
                }
            }
        }
        //Mostramos el tablero
        tablero(mesa);

        //Creamos la variable para guardar el valor al que vamos a ir
        int destino = 0;

        //Mientras la partida no haya acabado hacemos lo siguiente
        do {
            //Printeamos que se tiene que mover y los controles
            System.out.println("Muevete (1=arriba, 2=izquierda, 3=derecha, 4=abajo)");
            int lugar = s.nextInt();

            //Guardamos la posicion actual antes de moverse en variables nuevas
            int posanteriorx = posactualx;
            int posanteriory = posactualy;

            //Hacemos un switch case con lo que hara segun lo que el jugador ha puesto
            switch (lugar) {
                //Si puso 1 = arriba
                case 1:
                    //Vamos una fila arriba por lo que restamos
                    posactualx -= 1;
                    break;
                //Si puso 2 = izquierda
                case 2:
                    //Vamos una columna a la izquierda por lo que restamos
                    posactualy -= 1;
                    break;
                //Si puso 3 = derecha
                case 3:
                    //Vamos una columna a la derecha por lo que sumamos
                    posactualy += 1;
                    break;
                //Si puso 4 = abajo
                case 4:
                    //Vamos una fila abajo por lo que sumamos
                    posactualx += 1;
                    break;
                //Si no puso del 1 al 4 no sirve y lo vuelve a pedir
                default: System.out.println("Del 1 al 4");
            }

            //Creamos un booleano de cerca
            boolean cerca = false;

            //Si la posicion actual es mayor a 0 y es menor que el tamaño del array hacemos lo siguiente
            //Esto es para que no se vaya out of index
            if (posactualx >= 0 && posactualx < mesa.length && posactualy >= 0 && posactualy < mesa[0].length) {
                //Creamos el bucle que nos diga el mensaje de cerca
                for (int i = 0; i < direccionx.length; i++) {
                    //A las variables le sumamos la posicion actual mas las direcciones posibles
                    int cercax = posactualx + direccionx[i];
                    int cercay = posactualy + direcciony[i];

                    //Si el valor de esas variables es mayor y menor que el tamaño del array mesa hacemos lo siguiente
                    if (cercax >= 0 && cercax < mesa.length && cercay >= 0 && cercay < mesa[0].length) {
                        //Si en esas posiciones valen 1 o 2
                        if(mesa[cercax][cercay] == 1 || mesa[cercax][cercay] == 2) {
                            //Ponemos el booleano como true para imprimir el mensaje despues
                            cerca = true;
                        }
                    }

                }

                //Aqui guardamos el valor en la que estamos antes de cambiar los emojis
                //Es para no sobreescribir antes de tiempo el valor de la celda y asi poder printear bien
                destino = mesa[posactualx][posactualy];
                //Cambiamos el emoji de la posicion en la que estamos a la del jugador
                mesa[posactualx][posactualy] = 3;
                //Cambiamos el emoji de la posicion en la que estabamos antes por la x
                mesa[posanteriorx][posanteriory] = 0;

            } else {
                //Si no podemos hacer el movimiento porque nos vamos a salir del index printeamos el mensaje
                System.out.println("Te sales del tablero");
                //Y volvemos a la posicion anterior
                posactualx = posanteriorx;
                posactualy = posanteriory;
            }
            //Con el booleano si es true, que es si estamos cerca, printeamos el mensaje
            if(cerca) {
                System.out.println("Cerca");
            }
            //Mostramos el tablero
            tablero(mesa);

        } while (!acabar(mesa, destino));
    }
}
