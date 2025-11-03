import java.util.Scanner;

public class ejercicio8 {
    //Realizar el juego de la “Búsqueda del tesoro” donde si te acercas al tesoro te va avisando de
    //que hay un tesoro cerca pero agregando que tenemos dos posibles tesoros en el juego y
    //uno de ellos es un impostor

    public static void tablero(int[][] mesa) {
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                if(mesa[i][j] == 0) {
                    System.out.printf("%-5s", "X");
                }
                if(mesa[i][j] == 1) {
                    System.out.printf("%-5s", "X");
                }
                if(mesa[i][j] == 2) {
                    System.out.printf("%-5s", "X");
                }
                if(mesa[i][j] == 3) {
                    System.out.printf("%-5s", "\uD83D\uDE01");
                }

            }
            System.out.printf("%n");
        }
    }
    public static void tableroresultado(int[][] mesa) {
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                if(mesa[i][j] == 0) {
                    System.out.printf("%-5s", "X");
                }
                if(mesa[i][j] == 1) {
                    System.out.printf("%-5s", "\uD83E\uDE99");
                }
                if(mesa[i][j] == 2) {
                    System.out.printf("%-5s", "\uD83D\uDC80");
                }
                if(mesa[i][j] == 3) {
                    System.out.printf("%-5s", "\uD83D\uDC40");
                }

            }
            System.out.printf("%n");
        }
    }

    public static boolean acabar(int[][] mesa, int destino) {
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                if(destino == 1) {
                    System.out.println("\uD83E\uDE99 Ganaste \uD83D\uDC4F");
                    return true;
                }

                if(destino == 2) {
                    System.out.println("\uD83D\uDC80 Perdiste \uD83D\uDE02");
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] mesa = new int[5][5];
        int x = (int) (Math.random() * 5);
        int y = (int) (Math.random() * 5);
        mesa[x][y] = 1;
        do {
            x = (int) (Math.random() * 5);
            y = (int) (Math.random() * 5);
        } while (mesa[x][y] == 1);
        mesa[x][y] = 2;


        int posactualx = 0;
        int posactualy = 0;
        if(mesa[posactualx][posactualy] == 1 || mesa[posactualx][posactualy] == 2) {
            if(mesa[posactualx][posactualy] == 1) {
                x = (int) (Math.random() * 5);
                y = (int) (Math.random() * 5);
                mesa[x][y] = 1;
            }
            if(mesa[posactualx][posactualy] == 2) {
                x = (int) (Math.random() * 5);
                y = (int) (Math.random() * 5);
                mesa[x][y] = 2;
            }
        }
        mesa[posactualx][posactualy] = 3;
        int[] direccionx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] direcciony = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < direccionx.length; i++) {
            int cercax = posactualx + direccionx[i];
            int cercay = posactualy + direcciony[i];

            if (cercax >= 0 && cercax < mesa.length && cercay >= 0 && cercay < mesa[0].length) {
                if (mesa[cercax][cercay] == 1 || mesa[cercax][cercay] == 2) {
                    System.out.println("Cerca");
                    break;
                }
            }
        }
        tablero(mesa);

        int destino = -1;
        do {
            System.out.println("Muevete (1=arriba, 2=izquierda, 3=derecha, 4=abajo)");
            
            int lugar = s.nextInt();
            int posanteriorx = posactualx;
            int posanteriory = posactualy;
            switch (lugar) {
                case 1:
                    posactualx -= 1;
                    break;
                case 2:
                    posactualy -= 1;
                    break;
                case 3:
                    posactualy += 1;
                    break;
                case 4:
                    posactualx += 1;
                    break;
                default: System.out.println("Del 1 al 4");
            }
            //Estos son las direcciones posibles para buscar si esta cerca
            /*int[] direccionx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] direcciony = {-1, 0, 1, -1, 1, -1, 0, 1};*/

            boolean cerca = false;
            if (posactualx >= 0 && posactualx < mesa.length && posactualy >= 0 && posactualy < mesa[0].length) {
                for (int i = 0; i < direccionx.length; i++) {
                    int cercax = posactualx + direccionx[i];
                    int cercay = posactualy + direcciony[i];

                    if (cercax >= 0 && cercax < mesa.length && cercay >= 0 && cercay < mesa[0].length) {
                        if(mesa[cercax][cercay] == 1 || mesa[cercax][cercay] == 2) {
                            cerca = true;
                        }
                    }

                }
                destino = mesa[posactualx][posactualy];
                mesa[posactualx][posactualy] = 3;
                mesa[posanteriorx][posanteriory] = 0;
            } else {
                System.out.println("Te sales del tablero");
                posactualx = posanteriorx;
                posactualy = posanteriory;
            }
            if(cerca) {
                System.out.println("Cerca");
            }
            tablero(mesa);

        } while (!acabar(mesa, destino));
    }
}
