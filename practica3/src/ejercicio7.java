import java.util.Scanner;

public class ejercicio7 {
    //Modifica el programa del Ejercicio 6 para que:
    //1. Los números NO se repitan (como en el ejercicio anterior).
    //2. Los números estén comprendidos en un rango dinámico (el usuario introduce el valor mínimo y máximo).
    //3. Al final, el programa muestre:
    //○ La media aritmética de todos los números del array.
    //○ La posición de todos los números primos que haya en el array.
    //○ Una representación gráfica en consola de cada fila, donde cada número se represente con un número de * proporcional
    //a su valor dentro del rango dado (por ejemplo, si el rango es 10-20 y aparece el 15, se mostrarán 5 *).
    public static boolean esprimo(int numero) {
        if(numero<2) {
            return false;
        }
        for (int i = 2; i < numero ; i++) {
           if(numero % i == 0) {
              return false;
           }
        }
      return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int min;
        int max;

        do{
            System.out.println("Introduce el valor mínimo:");
            min = s.nextInt();
            System.out.println("Introduce el valor máximo:");
            max = s.nextInt();
            if(max < min) {
                System.out.println("El valor máximo no puede ser menor que el valor mínimo");
            }
        } while(max < min);

        //Creamos el array bidimensional de 6 filas y 10 columnas
        int[][] numeros = new int[6][10];
        //Creamos todas las variables que se utilizarán
        int maximo = 0;
        int minimo = 0;
        int maximoC = 0;
        String posmax = "";
        String posmin = "";
        int sumaT;
        int sumaF = 0;
        int sumaC = 0;
        //Pongo que minimoC valga 1001 para hacer las posteriores comparaciones q
        int minimoC = 1001;
        //Creamos las variables nuevas
        boolean repetido = false;
        int numeroactual = 0;
        //Creamos variables de intentos para poner 0 en las celdas que no logra encontrar un numero nuevo en los intentos dados
        int intentostotal = 100;
        int intentos;
        int contadormedia = (max-min)+1;

        //Creamos el bucle para rellenar el array con numeros aleatorios entre 0 y 1000
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                //Reiniciamos los intentos hechos en cada iteracion
                intentos = 0;
                //Creamos el do while para buscar el repetido mientras no el numero actual no este dentro del array
                do {
                    repetido = false;
                    //Generamos el numero entre 20 y 40
                    numeros[i][j] = min + (int) (Math.random() * (max-min+1));
                    //Vamos sumando uno al contador
                    intentos++;
                    //Guardamos el numero actual
                    numeroactual = numeros[i][j];
                    //Creamos los bucles para buscar si esta repetido
                    for (int k = 0; k < numeros.length; k++) {
                        for (int l = 0; l < numeros[k].length; l++) {
                            //Si k y l no estan en la misma posicion que i y j
                            if(!(k == i && l == j)) {

                                //Si el numero actual es igual a algun numero dentro array
                                if (numeroactual == numeros[k][l]) {
                                    repetido = true;

                                }
                                //Si ya se ha superado el limite de intentos (que son 100)
                                if(intentos >= intentostotal) {
                                    //Ponemos en esa posición el valor de 0
                                    numeros[i][j] = -9999;
                                    break;
                                }

                            }
                        }
                    }
                } while (repetido);
                if( numeros[i][j] >= 0) {
                    System.out.printf("|%-5d|",numeros[i][j]);
                } else {
                    System.out.printf("|%-5s|","");
                }

            }
            System.out.printf("%n");
        }

        //Bucle para calcular las sumas de las filas
        for (int i = 0; i < numeros.length; i++) {
            sumaT = 0;
            //Bucle para la suma de cada fila
            for (int j = 0; j < numeros[i].length; j++) {
                if( numeros[i][j] >= 0) {
                    sumaT += numeros[i][j];
                }
                if(esprimo(numeros[i][j])) {
                    System.out.println("El numero primo "+numeros[i][j]+" esta en la fila "+(i+1)+" y la columna "+(j+1));
                }
            }
            sumaF += sumaT;
        }

        System.out.println("Suma de las filas: " + sumaF);
        System.out.println("Media aritmetica: " + sumaF/contadormedia);
    }
}
