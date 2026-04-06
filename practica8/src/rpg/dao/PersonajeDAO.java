package rpg.dao;

import rpg.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PersonajeDAO {
    private Connection connection;
    private ArrayList<Personajes> personajes = new ArrayList<>();

    public PersonajeDAO() {
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

    public void cargarPersonajes() {
        try {
            Statement statement = connection.createStatement();
            Statement stRaza = connection.createStatement();
            Statement stClase = connection.createStatement();
            Statement stCiudad = connection.createStatement();
            Statement statement2 = connection.createStatement();
            Statement statement3 = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM personajes");

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int nivel = resultset.getInt("nivel");
                int oro = resultset.getInt("oro");
                int vida_actual = resultset.getInt("vida_actual");

                int id_raza = resultset.getInt("id_raza");
                Razas raza = null;
                ResultSet rsRaza = stRaza.executeQuery("SELECT * FROM RAZAS WHERE id = "+id_raza);

                while (rsRaza.next()) {
                    String nombreRaza = rsRaza.getString("nombre");
                    int bonificador_vida = rsRaza.getInt("bonificador_vida");
                    int bonificador_fuerza = rsRaza.getInt("bonificador_fuerza");

                    raza = new Razas(id_raza, nombreRaza, bonificador_vida, bonificador_fuerza);
                }


                int id_clase = resultset.getInt("id_clase");
                Clases_RPG clase = null;
                ResultSet rsClase = stClase.executeQuery("SELECT * FROM CLASES_RPG WHERE id = "+id_clase);

                while (rsClase.next()) {
                    String nombreClase = rsClase.getString("nombre");

                    clase = new Clases_RPG(id_clase, nombreClase);
                }


                int id_ciudad_actual = resultset.getInt("id_ciudad_actual");
                Ciudades ciudad = null;
                ResultSet rsCiudad = stCiudad.executeQuery("SELECT * FROM CIUDADES WHERE id = "+id_ciudad_actual);

                while (rsCiudad.next()) {
                    String nombreCiudad = rsCiudad.getString("nombre");
                    int nivel_minimo_acceso = rsCiudad.getInt("nivel_minimo_acceso");

                    ciudad = new Ciudades(id_ciudad_actual, nombreCiudad, nivel_minimo_acceso);
                }


                Personajes p = new Personajes(id, nombre, nivel, oro, vida_actual, raza, clase, ciudad);

                ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM PERSONAJES_HABILIDADES AS p INNER JOIN HABILIDADES AS h ON p.id_habilidad = h.id WHERE id_personaje = " + id);
                HashMap<Habilidades, Boolean> habilidadEquipada = new HashMap<>();
                while (resultSet2.next()) {

                    int id_habilidad = resultSet2.getInt("id");
                    String nombre_habilidad = resultSet2.getString("nombre");
                    int dano_base = resultSet2.getInt("dano_base");
                    int usos_maximos = resultSet2.getInt("usos_maximos");
                    int id_clase_habilidad = resultSet2.getInt("id_clase");

                    Boolean equipada_combate = resultSet2.getBoolean("equipada_combate");

                    Habilidades habilidadesPersonaje = new Habilidades(id_habilidad, nombre_habilidad, dano_base, usos_maximos, id_clase_habilidad);

                    habilidadEquipada.put(habilidadesPersonaje, equipada_combate);
                    p.addHabilidad(habilidadesPersonaje);
                }

                ResultSet rsInventario = statement3.executeQuery("SELECT * FROM INVENTARIOS AS i INNER JOIN ITEMS AS it ON i.id_item = it.id WHERE i.id_personaje ="+ id);
                HashMap<Items, Integer> itemCantidad = new HashMap<>();

                while (rsInventario.next()) {
                    int id_item = rsInventario.getInt("id_item");
                    Items item = null;
                    String nombreItem = rsInventario.getString("nombre");
                    String tipoItem = rsInventario.getString("tipo");
                    int precio_oroItem = rsInventario.getInt("precio_oro");
                    int bonificador_ataqueItem = rsInventario.getInt("bonificador_ataque");
                    int bonificador_defensaItem = rsInventario.getInt("bonificador_defensa");

                    item = new Items(id_item, nombreItem, tipoItem, precio_oroItem, bonificador_ataqueItem, bonificador_defensaItem);
                    int cantidad = rsInventario.getInt("cantidad");

                    itemCantidad.put(item, cantidad);

                    p.addInventario(itemCantidad);
                }

                personajes.add(p);

                System.out.println(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}