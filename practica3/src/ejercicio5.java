public class ejercicio5 {
    //Crear un programa que cuando se le introduzca números enteros
    //rellene un array de 6 filas por 10 columnas con números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos).
    //A continuación, el programa deberá:
    //- dar la posición del número máximo y mínimo
    //- la suma total de todas las filas y columnas
    //- la suma de todas las columnas
    //- la suma de todas las filas.
    public static void main(String[] args) {
        int[][] numeros = new int[6][10];
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


        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = (int) (Math.random()*1001);
                System.out.printf("|%-10d|", numeros[i][j]);
            }
            System.out.printf("%n");
        }

        for (int i = 0; i < numeros.length; i++) {
            if(i == 0) {
                maximo = numeros[i][0];
                minimo = numeros[i][0];
            }
            for (int j = 0; j < numeros[i].length; j++) {

                if(maximo < numeros[i][j]) {
                    maximo = numeros[i][j];
                    posmax = "Fila "+(i+1)+" y Columna "+(j+1);
                }
                if(minimo > numeros[i][j]) {
                    minimo = numeros[i][j];
                    posmin = "Fila "+(i+1)+" y Columna "+(j+1);
                }
            }

            if(maximo > maximoC) {
                maximoC = maximo;
            }

            if(minimo < minimoC) {
                minimoC = minimo;
            }
        }
        System.out.println("La posición del numero maximo ("+maximoC+") es "+posmax);
        System.out.println("La posición del numero minimo ("+minimoC+") es "+posmin);

        for (int i = 0; i < numeros.length; i++) {
            sumaT = 0;
            for (int j = 0; j < numeros[i].length; j++) {
                sumaT += numeros[i][j];
                for (int k = 0; k < numeros.length; k++) {
                    sumaC += numeros[k][j];

                }
            }
            System.out.println("Fila "+(i+1)+": "+sumaT);
            System.out.println("Columna "+(i+1)+": "+sumaC);
            sumaF += sumaT;
        }
        System.out.println("Suma de las filas: "+sumaF);
        System.out.println("Suma de las columnas: "+sumaC);
        System.out.println("Suma total de todas las filas y columnas: ");
    }
}
