package rpg.dao;

import rpg.model.Ciudades;

import java.sql.*;
import java.util.ArrayList;

public class CiudadesDAO {
    private Connection connection;
    private ArrayList<Ciudades> ciudades = new ArrayList<>();

    public CiudadesDAO() {
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

    public void cargarCiudades() {
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM CIUDADES");

            while (rs1.next()) {
                int id = rs1.getInt("id");
                String nombre = rs1.getString("nombre");
                int nivel_minimo_acceso = rs1.getInt("nivel_minimo_acceso");

                Ciudades ciudad = new Ciudades(id, nombre, nivel_minimo_acceso);
                ciudades.add(ciudad);
                System.out.println(ciudad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
