package rpg.dao;

import rpg.model.Clases_RPG;
import rpg.model.Habilidades;

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
          Statement st2 = connection.createStatement();
          ResultSet rs1 = st1.executeQuery("SELECT * FROM CLASES_RPG");
          ArrayList<Habilidades> listahabilidades = new ArrayList<>();

          while(rs1.next()) {
            int id = rs1.getInt("id");
            String nombre = rs1.getString("nombre");

            ResultSet rs2 = st2.executeQuery("SELECT * FROM HABILIDADES WHERE id_clase = "+id);

            while (rs2.next()) {
                int id_habilidad = rs2.getInt("id");
                String nombre_habilidad = rs2.getString("nombre");
                int dano_base = rs2.getInt("dano_base");
                int usos_maximos = rs2.getInt("usos_maximos");
                int id_clase = rs2.getInt("id_clase");

                Habilidades habilidad = new Habilidades(id_habilidad, nombre_habilidad, dano_base, usos_maximos, id_clase);
                listahabilidades.add(habilidad);

            }

            Clases_RPG claseRPG = new Clases_RPG(id, nombre);
            claseRPG.setListahabilidades(listahabilidades);

            clases.add(claseRPG);
          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
