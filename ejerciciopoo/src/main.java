import java.util.Scanner;

public class main {
    //Simulacion de registro de usuarios
    public static void validarRegistro(Usuario[] usuarios) {
        for (int i = 0; i < usuarios.length; i++) {
            if(usuarios[i].getCodigoPostal().startsWith("28")) {
                System.out.println("Usuario válido");
            } else {
                System.out.println("ERROR: Usuario "+usuarios[i].getNombre()+" bloqueado. Código Postal no permitido.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Creacion y almacenamiento de usuarios
        Usuario usuario1 = new Usuario("Mario","Escribano Cózar", "11630", "Calle Algar 5", "marioprogamer@gmail.com", "XxMarioxX");
        Usuario usuario2 = new Usuario("Óscar", "Álvarez Lucas", "11631", "Calle Panamá 8 2-I", "oscarprogamer@gmail.com", "XxOscarxX");
        Usuario usuario3 = new Usuario("José Miguel", "Miguel José", "28632", "IES Romero Vargas", "josemiguelprogamer@gmail.com", "XxJoseMiguelxX");

        Usuario[] usuarios = {usuario1, usuario2, usuario3};

        //validarRegistro(usuarios);

        //Simulacion de inicio de sesion y manejo de errores
        System.out.println("Dime el correo del usuario");
        String correo = s.nextLine();
        System.out.println("Dime la contraseña del usuario");
        String password = s.nextLine();
        if(usuario1.checkUsuario(correo,password) && correo.equals(usuario1.getEmail())) {
            System.out.println("Acceso concedido a "+usuario1.getNombre());
        }
        if(usuario2.checkUsuario(correo,password) && correo.equals(usuario2.getEmail())) {
            System.out.println("Acceso concedido a "+usuario2.getNombre());
        } else if (correo.equals(usuario2.getEmail())){
            System.out.println("¡ERROR! Contraseña incorrecta para "+usuario2.getEmail()+". Acceso denegado.");
        }

    }


}
