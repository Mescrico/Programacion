package rpg.dao;

import rpg.model.Ciudades;
import rpg.model.Clases_RPG;
import rpg.model.Habilidades;
import rpg.model.Items;

import java.sql.*;
import java.util.ArrayList;

public class HabilidadesDAO {
    private Connection connection;
    ArrayList<Habilidades> habilidades = new ArrayList<>();
    public HabilidadesDAO() {
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

    public void cargarHabilidades() {
        habilidades.clear();
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM HABILIDADES");

            while(rs1.next()) {
                int id = rs1.getInt("id");
                String nombre = rs1.getString("nombre");
                int dano_base = rs1.getInt("dano_base");
                int usos_maximos = rs1.getInt("usos_maximos");
                int id_clase = rs1.getInt("id_clase");

                Habilidades habilidad = new Habilidades(id, nombre, dano_base, usos_maximos, id_clase);
                habilidades.add(habilidad);
                System.out.println(habilidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Habilidades buscarHabilidadId(int id) {
        for (Habilidades h : habilidades) {
            if(h.getIdHabilidades() == id) {
                return h;
            }
        }
        return null;
    }

    public ArrayList<Habilidades> getHabilidades() {
        return habilidades;
    }

}
