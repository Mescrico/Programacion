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

    //Creamos la funcion para buscar si es primo
    public static boolean esprimo(int numero) {
        //Como el primo mas pequeño es 2, cualquier numero anterior a ese va a devolver falso
        if(numero<2) {
            return false;
        }
        //Creamos el bucle que vaya desde 2 hasta el numero
        for (int i = 2; i < numero ; i++) {
            //Si el resto del numero con cualquier numero anterior o consigo mismo da 0 entonces no es primo
            if(numero % i == 0) {
              return false;
            }
        }
        //Si no se cumple la condicion es primo y devuelve verdadero
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Creamos las variables para el minimo y el maximo
        int min;
        int max;
        //Hacemos un do while para que te este preguntando por el minimo y maximo mientras que maximo sea menor que minimo
        do{
            System.out.println("Introduce el valor mínimo:");
            min = s.nextInt();
            System.out.println("Introduce el valor máximo:");
            max = s.nextInt();
            //Si maximo es menor que minimo pedimos que vuelva a poner los valores
            if(max < min) {
                System.out.println("El valor máximo no puede ser menor que el valor mínimo");
            }
        } while(max < min);

        //Creamos el array bidimensional de 6 filas y 10 columnas
        int[][] numeros = new int[6][10];
        int sumaT;
        int sumaF = 0;
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
                //Creamos el do while para buscar si el numero actual ya estaba en el array
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
                                    //Ponemos en esa posición la celda vacia
                                    numeros[i][j] = min-1;
                                    break;
                                }

                            }
                        }
                    }
                } while (repetido);
                //Pongo que para los numeros mayores o igual que el minimo se muestren y en caso contrario se muestre un espacio en blanco
                if( numeros[i][j] >= min) {
                    System.out.printf("|%-5d|",numeros[i][j]);
                } else {
                    System.out.printf("|%-5s|","");
                }

            }
            System.out.printf("%n");
        }

        //Bucle para calcular las sumas de las filas y mostrar los numeros primos
        for (int i = 0; i < numeros.length; i++) {
            sumaT = 0;
            //Bucle para la suma de cada fila
            for (int j = 0; j < numeros[i].length; j++) {
                if( numeros[i][j] >= 0) {
                    sumaT += numeros[i][j];
                }
                //Si el numero es primo se muestra su posicion
                if(esprimo(numeros[i][j])) {
                    System.out.println("El numero primo "+numeros[i][j]+" esta en la fila "+(i+1)+" y la columna "+(j+1));
                }
            }
            sumaF += sumaT;
        }
        //La media es la suma total dividido entre la cantidad de numeros que hay
        System.out.println("Media aritmetica: " + sumaF/contadormedia);

        //Creamos las variables para los asteriscos
        double numeroasteriscos;
        int asteriscos;
        String repetir;

        //Creamos el bucle que calcule cuantos asteriscos les toca a cada numero
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                //Si el numero actual es mayor o igual que el minimo hacemos lo siguiente
                if (numeros[i][j] >= min) {
                    //Reiniciamos la variable repetir en cada iteracion
                    repetir = "";
                    //Calculamos el numero de asteriscos que le toca a cada uno con esta formula, que es el numero actual menos el minimo, dividido entre el maximo menos el minimo, multiplicado por 10 para que nos de un numero entre 0 y 10
                    numeroasteriscos = ((double) (numeros[i][j]-min)/(max-min))*10;
                    //Lo redondeamos para saber la cantidad exacta de asteriscos que le toca
                    asteriscos = (int) Math.round(numeroasteriscos);

                    //Creamos el bucle que ponga los asteriscos a cada numero
                    for (int k = 0; k < asteriscos; k++) {
                        //Vamos añadiendole asteriscos hasta alcanzar la cifra
                        repetir += "*";
                    }
                    //Printeamos la tabla con el numero de asteriscos
                    System.out.printf("|%-10s|", repetir);
                }
                //Si no hacemos lo siguiente
                else {
                    //Printeamos la tabla con la celda con espacio en blanco
                    System.out.printf("|%-10s|", "");
                }
            }
            System.out.printf("%n");
        }
    }
}