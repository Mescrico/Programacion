import model.Item;
import utils.JsonHelper;
import utils.TxtHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TxtHelper a = new TxtHelper();

        a.cargarFichero();

        JsonHelper ab = new JsonHelper();

        List<Item> hola = List.of(new Item("25","Macarrones","Comida",20));
        ab.writeList("practica7/Ficheros/items.json", hola);
    }
}
