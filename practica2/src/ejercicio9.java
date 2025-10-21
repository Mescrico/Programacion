import java.util.Scanner;

public class ejercicio9 {
    //Pida al usuario por teclado 10 números enteros y los guarde en un array
    //Recorra el array para encontrar:
    //El valor máximo y la posición en la que aparece.
    //El valor mínimo y la posición en la que aparece.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] numeros = new int[10];
        int[] posicion = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Pida al usuario por teclado 10 números enteros y los guarde en un array
        System.out.println("Di los 10 números");
        for(int i = 0; i <numeros.length; i++) {
            numeros[i] = s.nextInt();
        }

        int max = numeros[0];
        int min = numeros[0];
        int posMax = 0;
        int posMin = 0;

        //Recorra el array para encontrar:
        for(int k = 0; k <numeros.length; k++) {
            //El valor máximo y la posición en la que aparece.
            if(numeros[k] >= max) {
                max = numeros[k];
                posMax = posicion[k];
            }
            //El valor mínimo y la posición en la que aparece.
            if(numeros[k] <= min) {
                min = numeros[k];
                posMin = posicion[k];
            }

        }
        System.out.println("Valor máximo: "+max+" en la posición "+posMax);
        System.out.println("Valor mínimo: "+min+" en la posición "+posMin);
    }
}
