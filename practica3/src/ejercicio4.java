public class ejercicio4 {
    //Modifica el programa anterior de tal forma que las sumas parciales y la suma total
    //aparezcan en la pantalla con un pequeño retraso,
    //dando la impresión de que el ordenador se queda “pensando” antes de mostrar los números.
    public static void main(String[] args) {
        //Creamos el array de 4 filas y 5 columnas
        int[][] numeros = new int[4][5];

        //Definimos las variables suma total, suma (de filas) y mayor (para el numero mayor de cada columna)
        int sumaT = 0;
        int suma = 0;
        int mayor = 0;

        //Hacemos el bucle que ponga los numeros aleatorios
        for (int i = 0; i <numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                //Usamos el math.random para que genere un numero hasta el 1999 (sin contarlo) y le sumamos 1 para que sea desde el 1 hasta 1999
                numeros[i][j] = 1 + (int) (Math.random()*1999);
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
            //Usamos el try catch y Thread.sleep para dar el retraso
            try {
                //El retraso es de 300 milisegundos
                Thread.sleep(300);
            } catch (InterruptedException f) {
                f.printStackTrace();
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

        try {
            Thread.sleep(300);
        } catch (InterruptedException f) {
            f.printStackTrace();
        }
        System.out.print("||  "+sumaT);


    }

}
