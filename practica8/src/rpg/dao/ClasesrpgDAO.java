package rpg.dao;

import rpg.model.Clases_RPG;

import java.sql.*;
import java.util.ArrayList;

public class ClasesrpgDAO {
    private Connection connection;
    private ArrayList<Clases_RPG> clases = new ArrayList<>();

    public ClasesrpgDAO() {
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

    public void cargarClases() {
        try {
          Statement st1 = connection.createStatement();
          ResultSet rs1 = st1.executeQuery("SELECT * FROM CLASES_RPG");

          while(rs1.next()) {
            int id = rs1.getInt("id");
            String nombre = rs1.getString("nombre");

            Clases_RPG clasesRPG = new Clases_RPG(id, nombre);
            clases.add(clasesRPG);
          }
        } catch (SQLException e ) {
            throw new RuntimeException(e);
        }
    }
}
