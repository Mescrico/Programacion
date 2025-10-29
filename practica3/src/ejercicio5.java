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
        //Pongo que minimoC valga 1001 para hacer las posteriores comparaciones
        int minimoC = 1001;

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = (int) (Math.random()*1001);
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            if(i == 0) {
                maximo = numeros[i][0];
                minimo = numeros[i][0];
            }
            for (int j = 0; j < numeros[i].length; j++) {
                if(maximo < numeros[i][j]) {
                    maximo = numeros[i][j];
                }
                if(minimo > numeros[i][j]) {
                    minimo = numeros[i][j];
                }
            }
            if(maximo > maximoC) {
                maximoC = maximo;
            }
            if(minimo < minimoC) {
                minimoC = minimo;
            }
        }
        System.out.println(maximoC);
        System.out.println(minimoC);
    }
}
