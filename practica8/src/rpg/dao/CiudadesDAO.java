package rpg.dao;

import rpg.model.Ciudades;
import rpg.model.Items;
import rpg.utils.LoggerCustom;

import java.sql.*;
import java.time.LocalDateTime;
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
            LoggerCustom.logError("Conexión de la base de datos");
            e.printStackTrace();
        }
    }

    public void cargarCiudades() {
        ciudades.clear();
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
            LoggerCustom.logInfo("Ciudades cargadas");
        } catch (SQLException e) {
            LoggerCustom.logError("Cargando ciudades: "+e.getClass().getSimpleName()+" - "+e.getMessage());
            throw new RuntimeException(e);

        }
    }

    public Ciudades buscarCiudadId(int id) {
        for (Ciudades c : ciudades) {
            if(c.getIdCiudades() == id) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Ciudades> getCiudades() {
        return ciudades;
    }
}
