import java.util.Scanner;

public class ejercicio8 {
    //Programa Java para leer la altura de N personas y calcular la altura media.
    //Calcular cuántas personas tienen una altura superior a la media y cuántas tienen una altura inferior a la media.
    //El valor de N se pide por teclado y debe ser entero positivo
    public static void main(String[] args) {
        //Programa Java para leer la altura de N personas y calcular la altura media.
        //El valor de N se pide por teclado y debe ser entero positivo
        Scanner s = new Scanner(System.in);
        System.out.println("De cuanto quieres el array");
        int tamaño = s.nextInt();
        while(tamaño <= 0) {
            System.out.println("No sirve, solo números enteros y mayores que 0");
            tamaño = s.nextInt();

        }
        double[] n = new double[tamaño];
        double sumaA = 0;
        int contadorA = 0;
        int mayor = 0;
        int menor = 0;

        for(int i = 0; i<n.length; i++) {
            System.out.println("Introduce una altura");
            n[i] = s.nextDouble();
            while(n[i] <= 0) {
                System.out.println("No sirve, solo números positivos y mayores que 0");
                n[i] = s.nextDouble();
            }
            sumaA += n[i];
            contadorA++;
        }
        double mediaA = (double) sumaA / (double) contadorA;
        System.out.println("La media es de: "+mediaA);
        //Calcular cuántas personas tienen una altura superior a la media y cuántas tienen una altura inferior a la media.
        for(int i = 0; i <tamaño; i++) {
            if(n[i] > mediaA) {
                mayor++;
            }
            if(n[i] < mediaA) {
                menor++;
            }
        }
        System.out.println("Hay "+mayor+" números mayor que la media");
        System.out.println("Hay "+menor+" números menor que la media");


    }
}
