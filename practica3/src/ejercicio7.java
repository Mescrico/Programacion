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

        //Creamos el bucle para rellenar el array con numeros aleatorios entre 0 y 1000
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                //Reiniciamos los intentos hechos en cada iteracion
                intentos = 0;
                //Creamos el do while para buscar el repetido mientras no el numero actual no este dentro del array
                do {
                    repetido = false;
                    //Generamos el numero entre 20 y 40
                    numeros[i][j] = 20 + (int) (Math.random() * 21);
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
                                    numeros[i][j] = 0;
                                    break;
                                }

                            }
                        }
                    }
                } while (repetido);
            }
        }
        //Creamos el bucle para buscar la posición de los valores minimo y maximo
        for (int i = 0; i < numeros.length; i++) {
            //Guardamos el primer valor para que no se reinicie en cada iteracion
            if (i == 0) {
                maximo = numeros[i][0];
                minimo = numeros[i][0];
            }
            //Creamos el bucle que busque la posición
            for (int j = 0; j < numeros[i].length; j++) {
                //Si maximo es menor que el numero actual
                if (maximo < numeros[i][j]) {
                    //Maximo sera ese numero
                    maximo = numeros[i][j];
                    posmax = "Fila " + (i + 1) + " y Columna " + (j + 1);
                }
                //Si minimo es mayor que el numero actual
                if (minimo > numeros[i][j]) {
                    //Minimo sera ese numero
                    minimo = numeros[i][j];
                    posmin = "Fila " + (i + 1) + " y Columna " + (j + 1);
                }
            }
            //Si el maximo actual es mayor que el maximo global (que en la primera iteracion es 0)
            if (maximo > maximoC) {
                //Maximo global sera ese maximo
                maximoC = maximo;
            }
            //Si el minimo actual es menor que el minimo global (que en la primera iteracion es 1001)
            if (minimo < minimoC) {
                //Minimo global sera ese minimo
                minimoC = minimo;
            }
        }
        System.out.println("La posición del numero maximo (" + maximoC + ") es " + posmax);
        System.out.println("La posición del numero minimo (" + minimoC + ") es " + posmin);

        //Bucle para calcular las sumas de las filas
        for (int i = 0; i < numeros.length; i++) {
            sumaT = 0;
            //Bucle para la suma de cada fila
            for (int j = 0; j < numeros[i].length; j++) {
                sumaT += numeros[i][j];
            }
            System.out.println("Suma de la fila " + (i + 1) + ": " + sumaT);
            sumaF += sumaT;
        }
        //Bucle para calcular las sumas de las columnas
        for (int j = 0; j < numeros[0].length; j++) {
            sumaT = 0;
            //Bucle para la suma de las columnas
            for (int i = 0; i < numeros.length; i++) {
                ;
                sumaT += numeros[i][j];
            }
            System.out.println("Suma de la columna " + (j + 1) + ": " + sumaT);
            sumaC += sumaT;
        }
        System.out.println("Suma de las filas: " + sumaF);
        System.out.println("Suma de las columnas: " + sumaC);
        System.out.println("Suma total de todas las filas y columnas: " + sumaF);
    }
}
