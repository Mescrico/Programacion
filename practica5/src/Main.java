import modelo.Creacion;
import presentacion.Presentacion;

public class Main {
    public static void main(String[] args) {
        Creacion creacion = new Creacion();
        Presentacion presentacion = new Presentacion(creacion);

        presentacion.menu();
    }
}