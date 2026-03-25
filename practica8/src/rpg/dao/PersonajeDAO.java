package rpg.dao;

import rpg.model.Personajes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO {


    public PersonajeDAO() {
        try(
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/XRPG");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM personajes")) {
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int nivel = resultset.getInt("nivel");
                int oro = resultset.getInt("oro");
                int vida_actual = resultset.getInt("vida_actual");
                int id_raza = resultset.getInt("id_raza");
                int id_clase = resultset.getInt("id_clase");
                int id_ciudad_actual = resultset.getInt("id_ciudad_actual");

            }

        } catch (SQLException e) {
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }
    }
}
