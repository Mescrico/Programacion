package rpg.dao;

import rpg.model.Clases_RPG;
import rpg.model.Razas;

import java.sql.*;
import java.util.ArrayList;

public class RazasDAO {
    private Connection connection;
    private ArrayList<Razas> razas = new ArrayList<>();

    public RazasDAO() {
        try {
            String url = "jdbc:postgresql://localhost:5432/XRPG";
            String user = "xrpg_user";
            String pass = "xrpg_password";

            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }
        cargarRazas();
    }

    public void cargarRazas() {
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM RAZAS");

            while (rs1.next()) {
                int id = rs1.getInt("id");
                String nombre = rs1.getString("nombre");
                int bonificador_vida = rs1.getInt("bonificador_vida");
                int bonificador_fuerza = rs1.getInt("bonificador_fuerza");

                Razas raza = new Razas(id, nombre, bonificador_vida, bonificador_fuerza);
                razas.add(raza);
                System.out.println(raza);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Razas> getRazas() {
        return razas;
    }
}
