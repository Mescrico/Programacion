import model.Item;
import model.Personaje;
import services.GestionMundo;
import utils.JsonHelper;
import utils.TxtHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestionMundo g = new GestionMundo();

        g.cargarTodo();

        g.crearPersonaje();

        g.guardarCambios();
    }
}
