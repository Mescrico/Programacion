package rpg.dao;

import rpg.model.Items;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAO {
    private Connection connection;
    private ArrayList<Items> items = new ArrayList<>();

    public ItemDAO() {
        try {
            String url = "jdbc:postgresql://localhost:5432/XRPG";
            String user = "xrpg_user";
            String pass = "xrpg_password";

            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }
    }

    public void cargarItems() {
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM ITEMS");

            while (rs1.next()) {
                int id = rs1.getInt("id");
                String nombre = rs1.getString("nombre");
                String tipo = rs1.getString("tipo");
                int precio_oro = rs1.getInt("precio_oro");
                int bonificador_ataque = rs1.getInt("bonificador_ataque");
                int bonificador_defensa = rs1.getInt("bonificador_defensa");

                Items item = new Items(id, nombre, tipo, precio_oro, bonificador_ataque, bonificador_defensa);
                items.add(item);
            }
            System.out.println(items);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
