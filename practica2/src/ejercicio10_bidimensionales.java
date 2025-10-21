import java.util.Scanner;

public class ejercicio10_bidimensionales {
    //Crea un programa que muestre por pantalla la nota de un estudiante, de entre una lista de estudiantes con sus respectivas notas
    //El nombre del estudiante lo introduce el usuario por teclado (usa la clase Scanner)
    //Utiliza un array para los nombres de los alumnos y otro para las notas. ¿Serías capaz de hacerlo con un array BIdimensional?
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Creación del array multidimensional
        String[][] nombrenota = {{"Mario", "10"}, {"Óscar", "0"}, {"Mortadelo", "5"}, {"Filemon", "5"}};
        //Pedimos el nombre del estudiante por teclado
        String entrada = s.nextLine();

        //Creamos el for para comparar el nombre escrito por teclado con el array bidimensional
        for (int i = 0; i < nombrenota.length; i++) {
            //Si es igual imprimimos nombre y nota
            if(nombrenota[i][0].equals(entrada)) {
                System.out.println("Nombre: "+nombrenota[i][0]+" Nota: "+nombrenota[i][1]);
                break;
            }
            //Seguimos comparando y si sigue sin ser igual hasta el último dato del array imprime el mensaje de error
            else if (i == nombrenota.length -1 && !nombrenota[i][0].equals(entrada)){
                System.out.println("Nombre no encontrado");
            }

        }

    }
}
