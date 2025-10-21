import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio14 {
    //Crea un programa que:
    //Cree una lista de Strings (ArrayList<String>).
    //Pida al usuario nombres por teclado hasta que introduzca la palabra "fin".
    //Luego pida un nombre a buscar y diga si está en la lista o no, mostrando también en qué posición se encuentra si existe.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Creamos la lista de Strings
        ArrayList<String> lista = new ArrayList<>();

        String nombre;
        //Hacemos el bucle para que pedir nombres
        do{
            System.out.println("Di el nombre (fin = termina)");
            nombre = s.nextLine();
            //Si el nombre no es igual a fin se añade a la lista
            if(!nombre.equals("fin")) {
                lista.add(nombre);
            }
        } while(!nombre.equals("fin"));

        System.out.println("Dime un nombre a buscar");
        String buscar = s.nextLine();

        //Si el nombre está en la lista se mostrará su posición
        if(lista.contains(buscar)) {
            System.out.println("Está en la lista, en la posición "+lista.indexOf(buscar));
        } else {
            System.out.println("No está en la lista");
        }
    }
}
