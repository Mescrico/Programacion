import java.util.Scanner;

public class ejercicio2 {
    //Escribe un programa que solicite 20 números enteros. 
    //Estos números debemos de introducirlo en un array de 4 filas por 5 columnas. 
    //El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna. 
    //La suma total debe aparecer en la esquina inferior derecha.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Creamos el array de 4 filas y 5 columnas
        int[][] numeros = new int[4][5];

        //Definimos las variables suma total, suma (de filas) y mayor (para el numero mayor de cada columna)
        int sumaT = 0;
        int suma = 0;
        int mayor = 0;

        //Pedimos los 20 numeros enteros
        System.out.println("Escribe 20 números enteros");
        for (int i = 0; i <numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = s.nextInt();
            }
        }

        //Creamos el bucle que muestre los numeros por pantallas divididos en filas y columnas
        for (int i = 0; i < numeros.length; i++) {
            //Hacemos que cada vez que el bucle lo recorra una vuelta la variable de la suma de filas sea 0
            suma = 0;
            //Hacemos un bucle para mostrar los numeros
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print("|  "+numeros[i][j]+"  |");
                //Vamos sumando la suma mas cada numero del array bidimensional
                suma += numeros[i][j];

            }
            System.out.print("||  "+suma);
            //Usamos este printf %n para hacer un salto de linea
            System.out.printf("%n");
            //A la suma total le vamos sumando la suma de la fila al final de cada vuelta
            sumaT += suma;

        }
        System.out.println("------------------------------------------------");

        //Creamos el bucle que nos diga cual es el numero mayor de cada columna
        for (int j = 0; j < numeros[0].length; j++) {
            //Predefinimos al mayor como el primer numero de cada columna
            mayor = numeros[0][j];
            //Creamos el bucle para poder comparar con distintas columnas
            for (int i = 1; i < numeros.length; i++) {
                //Si mayor es menor que otro numero de su misma columna mayor pasa a ser ese numero
                if(mayor < numeros[i][j]) {
                    mayor = numeros[i][j];
                }
            }
            //Sumamos la suma total (que ya tiene la suma de las filas) mas la suma de cada numero mayor de la columna
            sumaT += mayor;
            System.out.print("|  "+mayor+"  |");
        }
        System.out.print("||  "+sumaT);


    }
}
