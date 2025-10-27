import java.util.Scanner;

public class ejercicio2 {
    //Escribe un programa que solicite 20 números enteros. 
    //Estos números debemos de introducirlo en un array de 4 filas por 5 columnas. 
    //El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna. 
    //La suma total debe aparecer en la esquina inferior derecha.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] numeros = new int[4][5];
        int suma = 0;
        System.out.println("Escribe 20 números enteros");
        for (int i = 0; i <numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = s.nextInt();
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            suma = 0;
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print("|  "+numeros[i][j]+"  |");
                suma += numeros[i][j];

            }
            System.out.print("||  "+suma);
            System.out.printf("%n");
        }
        System.out.println("----------------------------------------------------");
        int mayor = 0;
        int sumaT = 0;
        for (int j = 0; j < numeros[0].length; j++) {
            sumaT = 0;
            mayor = numeros[0][j];
            for (int i = 1; i < numeros.length; i++) {
                if(mayor < numeros[i][j]) {
                    mayor = numeros[i][j];
                }
                sumaT += mayor + suma;


            }
            System.out.print("|  "+mayor+"  |");
        }
        System.out.print(sumaT);


    }
}
