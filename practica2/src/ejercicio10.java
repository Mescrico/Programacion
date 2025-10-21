import java.util.Scanner;

public class ejercicio10 {
    //Crea un programa que muestre por pantalla la nota de un estudiante, de entre una lista de estudiantes con sus respectivas notas
    //El nombre del estudiante lo introduce el usuario por teclado (usa la clase Scanner)
    //Utiliza un array para los nombres de los alumnos y otro para las notas. ¿Serías capaz de hacerlo con un array BIdimensional?
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Crea un programa que muestre por pantalla la nota de un estudiante, de entre una lista de estudiantes con sus respectivas notas
        System.out.println("Diga el nombre del estudiante");
        String[] nombres = {"Mario", "Óscar", "Mortadelo", "Filemon"};
        //El nombre del estudiante lo introduce el usuario por teclado (usa la clase Scanner)
        String entrada = s.nextLine();

        int[] notas = {10, 0, 5, 5};
        //Creamos el for para comparar el valor enviado por el teclado con el array
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equals(entrada)) {
                System.out.println("Nombre: " + nombres[i] + " Nota: " + notas[i]);
                break;
            }
            //Si no es igual comparamos hasta el último dato del array y si no esta ahí mostramos el mensaje
            else if (i == nombres.length - 1 && !nombres[i].equals(entrada)) {
                System.out.println("Nombre no encontrado");
            }

        }
    }
}
