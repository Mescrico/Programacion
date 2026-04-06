import rpg.dao.ItemDAO;
import rpg.dao.PersonajeDAO;
import rpg.model.Items;

public class Main {
    public static void main(String[] args) {
        PersonajeDAO a = new PersonajeDAO();
        ItemDAO b = new ItemDAO();

        a.cargarPersonajes();
        b.cargarItems();
    }
}