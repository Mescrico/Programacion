public class ejercicio1 {
    //Define un array de números tipo double de 3 filas por 7 columnas con nombre doub
    //asigna los valores según la siguiente tabla.
    //Muestra el contenido de todos los elementos del array dispuestos en forma de tabla como se muestra en la figura.
    static void main(String[] args) {
        //Creamos el array bidimensional de 3 filas y 7 columnas
        double[][] doub = new double[3][6];

        //Definimos los valores en las posiciones (le he colocado el valor 100 a las que en la tabla no tienen valor para hacer lo siguiente)
        doub[0][0] = 0; doub[0][1] = 30; doub[0][2] = 2;
        doub[0][3] = 100; doub[0][4] = 100; doub[0][5] = 5;
        doub[1][0] = 75; doub[1][1] = 100; doub[1][2] = 100;
        doub[1][3] = 100; doub[1][4] = 0; doub[1][5] = 100;
        doub[2][0] = 100; doub[2][1] = 100; doub[2][2] = -2;
        doub[2][3] = 9; doub[2][4] = 100; doub[2][5] = 11;

        //Creamos un array para guardar los textos de la tabla
        String[] columnas = {"Array num", "Columna 0", "Columna 1", "Columna 2", "Columna 3", "Columna 4", "Columna 5"};
        //Creamos un bucle que ponga los textos de la tabla
        for (int i = 0; i < columnas.length; i++) {
            //Con el printf %-12s guardamos 12 espacios para el texto
            System.out.printf("%-12s", columnas[i]);
        }
        //Printeamos un salto de linea
        System.out.printf("%n");

        //Creamos el bucle que vaya mostrando la tabla con los valores segun la posicion
        for (int i = 0; i < doub.length; i++) {
            //Creamos el texto fila de la tabla
            System.out.printf("%-4s "+i+" %4s", "Fila", "");
            for (int j = 0; j < doub[i].length; j++) {
                //Si el numero no es 100, lo mostramos por pantalla
                if(doub[i][j] != 100) {
                    //Usamos el %-10.0f para guardar 10 espacios
                    System.out.printf("|%-10.0f|", doub[i][j]); //El %.0f es para mostrar el valor sin decimales
                }
                //En caso contrario muestra un espacio vacio
                else {
                    //Usamos el %-10s para imprimir 10 espacios de strings, en este caso los espacios en blancos
                    System.out.printf("|%-10s|", "");
                }
            }
            //Printeamos un salto de linea
            System.out.printf("%n");
        }
    }
}
