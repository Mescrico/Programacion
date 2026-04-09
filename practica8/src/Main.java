import rpg.dao.*;
import rpg.logic.GestionMundo;
import rpg.model.Ciudades;
import rpg.model.Items;
import rpg.ui.Menu;

public class Main {
    public static void main(String[] args) {
        GestionMundo g = new GestionMundo();

        Menu m = new Menu();
        m.menu();
    }
}