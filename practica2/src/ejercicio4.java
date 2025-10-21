public class ejercicio4 {
    //Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100.
    //Obtén la suma de todos ellos y la media
    public static void main(String[] args) {
        //Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100.
        int[] x = new int[100];
        for(int i=0; i<x.length; i++) {
            x[i] = i+1;
        }
        System.out.println(x[0]);
        //Obtén la suma de todos ellos y la media
        int suma = x[0];
        for(int i=1; i<x.length; i++) {
            suma += x[i];
        }
        double media = (double) suma / (double) x.length;
        System.out.println("La suma es: "+suma);
        System.out.println("La media es: "+media);
    }
}
