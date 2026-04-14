package rpg.logic;

import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.model.*;
import rpg.ui.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    private Connection connection;
    private Scanner s = new Scanner(System.in);

    private List<Ciudades> ciudades;
    private List<Clases_RPG> clases_rpgs;
    private List<Habilidades> habilidades;
    private List<Items> items;
    private List<Personajes> personajes;
    private List<Razas> razas;

    private CiudadesDAO ciudadesDAO;
    private ClasesrpgDAO clasesrpgDAO;
    private HabilidadesDAO habilidadesDAO;
    private ItemDAO itemDAO;
    private PersonajeDAO personajeDAO;
    private RazasDAO razasDAO;


    private Menu m;

    public GestionMundo() {
        try {
            String url = "jdbc:postgresql://localhost:5432/XRPG";
            String user = "xrpg_user";
            String pass = "xrpg_password";

            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println("Error en la conexión de la base de datos");
            e.printStackTrace();
        }
        ciudades = new ArrayList<>();
        clases_rpgs = new ArrayList<>();
        habilidades = new ArrayList<>();
        items = new ArrayList<>();
        personajes = new ArrayList<>();
        razas = new ArrayList<>();

        ciudadesDAO = new CiudadesDAO();
        clasesrpgDAO = new ClasesrpgDAO();
        habilidadesDAO = new HabilidadesDAO();
        itemDAO = new ItemDAO();
        personajeDAO = new PersonajeDAO();
        razasDAO = new RazasDAO();

        ciudadesDAO.cargarCiudades();
        clasesrpgDAO.cargarClases();
        habilidadesDAO.cargarHabilidades();
        itemDAO.cargarItems();
        personajeDAO.cargarPersonajes();
        razasDAO.cargarRazas();

        ciudades = ciudadesDAO.getCiudades();
        clases_rpgs = clasesrpgDAO.getClases();
        habilidades = habilidadesDAO.getHabilidades();
        items = itemDAO.getItems();
        personajes = personajeDAO.getPersonajes();
        razas = razasDAO.getRazas();

    }

    public void crearPersonaje() {
        try {
            System.out.println("Pon el nombre del personaje:");
            String nombrePersonaje = s.next();
            System.out.println("Razas disponibles:");
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM RAZAS");

            while(rs1.next()) {
                int idRaza = rs1.getInt("id");
                String nombreRaza = rs1.getString("nombre");
                int bonificadorVida = rs1.getInt("bonificador_vida");
                int bonificadorFuerza = rs1.getInt("bonificador_fuerza");

                System.out.println("ID: "+idRaza+" - "+nombreRaza+" - Bonificador Vida: "+bonificadorVida+" - Bonificador Fuerza: "+bonificadorFuerza);
            }

            boolean bien = false;
            Razas raza = null;
            while (!bien) {
                System.out.println("Elige por id:");
                int opcion = s.nextInt();

                Statement st2 = connection.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT * FROM RAZAS WHERE id = "+opcion);

                if(rs2.next()) {
                    int idRaza = rs2.getInt("id");
                    String nombreRaza = rs2.getString("nombre");
                    int bonificadorVida = rs2.getInt("bonificador_vida");
                    int bonificadorFuerza = rs2.getInt("bonificador_fuerza");

                    raza = new Razas(idRaza, nombreRaza, bonificadorVida, bonificadorFuerza);
                    bien = true;
                } else {
                    System.out.println("Esa id no existe");
                }
            }

            System.out.println("Clases disponibles:");

            Statement st3 = connection.createStatement();
            ResultSet rs3 = st3.executeQuery("SELECT * FROM CLASES_RPG");

            while(rs3.next()) {
                int idClase = rs3.getInt("id");
                String nombreClase = rs3.getString("nombre");

                System.out.println("ID: "+idClase+" - "+nombreClase);
            }

            boolean correcto = false;
            Clases_RPG clase = null;

            while (!correcto) {
                System.out.println("Elige por id:");
                int opcion = s.nextInt();

                Statement st4 = connection.createStatement();
                ResultSet rs4 = st4.executeQuery("SELECT * FROM CLASES_RPG WHERE id = "+opcion);

                if(rs4.next()) {
                    int idClase = rs4.getInt("id");
                    String nombreClase = rs4.getString("nombre");

                    clase = new Clases_RPG(idClase, nombreClase);
                    correcto = true;
                } else {
                    System.out.println("Esa id no existe");
                }
            }

            PreparedStatement ps = connection.prepareStatement("INSERT INTO PERSONAJES (nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual) VALUES (?, 1, 100, ?, ?, ?, 1)");

            ps.setString(1, nombrePersonaje);
            ps.setInt(2, 100+raza.getBonificador_vida());
            ps.setInt(3, raza.getIdRaza());
            ps.setInt(4, clase.getIdClasesRPG());

            ps.executeUpdate();

            ResultSet rs2 = ps.getGeneratedKeys();
            int idPersonaje = 0;

            if(rs2.next()) {
                idPersonaje = rs2.getInt("id");
            }

            Personajes personaje = new Personajes(idPersonaje, nombrePersonaje, 1, 100, 100 + raza.getBonificador_vida(), raza, clase, ciudades.getFirst());
            System.out.println("Personaje "+nombrePersonaje+" creado");
            personajes.add(personaje);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viajarDeCiudad() {

        boolean existe = false;
        Personajes personaje = null;
        while(!existe) {
            System.out.println("ID del personaje que va a cambiar de ciudad");
            int id = s.nextInt();
            personaje = personajeDAO.buscarPersonajeId(id);

            if(personaje == null) {
                System.out.println("Esa id no existe");
            } else {
                existe = true;
            }

        }
        String nombreCiudadPersonaje;
        if(personaje.getCiudad() == null) {
            nombreCiudadPersonaje = "Ciudad no existe";
        } else {
            nombreCiudadPersonaje = personaje.getCiudad().getNombre();
        }


        System.out.println("Nueva ciudad del personaje? (Antigua: "+nombreCiudadPersonaje+")");
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println("ID:"+ciudades.get(i).getIdCiudades()+" - Nombre: "+ciudades.get(i).getNombre()+" - Nivel minimo: "+ciudades.get(i).getNivel_minimo_acceso());
        }

        boolean bien = false;
        Ciudades ciudadE = null;
        while(!bien) {
            System.out.println("Elige por id");
            int opcion = s.nextInt();

            ciudadE = ciudadesDAO.buscarCiudadId(opcion);

            if (ciudadE == null) {
                System.out.println("Esa id no existe");
            } else {
                try {
                    if(ciudadE.getNivel_minimo_acceso() > personaje.getNivel()) {
                        System.out.println("El personaje tiene menos nivel "+personaje.getNivel()+" que el requerido "+ciudadE.getNivel_minimo_acceso());
                        throw new FondosInsuficientesException("El personaje tiene menos nivel "+personaje.getNivel()+" que el requerido "+ciudadE.getNivel_minimo_acceso());
                    } else {
                        try {
                            PreparedStatement ps1 = connection.prepareStatement("UPDATE PERSONAJES SET id_ciudad_actual = ? WHERE id = ?");

                            ps1.setInt(1, ciudadE.getIdCiudades());
                            ps1.setInt(2, personaje.getIdPersonaje());

                            ps1.executeUpdate();

                            personaje.setCiudad(ciudadE);

                            System.out.println(personaje.getNombre()+" a viajado a "+ciudadE.getNombre());
                            bien = true;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (FondosInsuficientesException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void comprarItems() {
        boolean idPExiste = false;
        Personajes personaje = null;
        while(!idPExiste) {
            System.out.println("ID del personaje que va a comprar");
            int id = s.nextInt();
            personaje = personajeDAO.buscarPersonajeId(id);

            if (personaje == null) {
                System.out.println("Esa id no existe");
            } else {
                idPExiste = true;
            }

        }

        System.out.println("Saldo de "+personaje.getNombre()+": "+personaje.getOro());

        System.out.println("Tienda:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("ID: "+items.get(i).getIdItem()+" - Nombre: "+items.get(i).getNombre()+" - Tipo: "+items.get(i).getTipo()+" - Precio: "+items.get(i).getPrecio_oro()+" - Bonificador ataque: "+items.get(i).getBonificador_ataque()+" - Bonificador defensa: "+items.get(i).getBonificador_defensa());
        }

        boolean idIExiste = false;
        Items item = null;
        while(!idIExiste) {
            System.out.println("ID del item a comprar");
            int id = s.nextInt();
            item = itemDAO.buscarItemId(id);

            if (item == null) {
                System.out.println("Esa id no existe");
            } else {
                idIExiste = true;
            }
        }

        if(personaje.getOro() >= item.getPrecio_oro()) {
            System.out.println(personaje.getNombre()+" a comprado "+item.getNombre());

            personaje.setOro(personaje.getOro() - item.getPrecio_oro());

            int cantidadOro = personaje.getOro();
            System.out.println("Saldo de "+personaje.getNombre()+": "+cantidadOro);

            try {
                PreparedStatement psOro = connection.prepareStatement("UPDATE PERSONAJES SET oro = ? WHERE id = "+personaje.getIdPersonaje());
                psOro.setInt(1, cantidadOro);

                psOro.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            if(personaje.getInventario().containsKey(item)) {
                try {
                    PreparedStatement ps = connection.prepareStatement("UPDATE inventarios iv SET cantidad = ? WHERE iv.id_item = ? AND iv.id_personaje = ?");
                    ps.setInt(1, personaje.getInventario().get(item)+1);
                    ps.setInt(2, item.getIdItem());
                    ps.setInt(3, personaje.getIdPersonaje());

                    ps.executeUpdate();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    personaje.addItem(item);
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO INVENTARIOS (ID_PERSONAJE, ID_ITEM, CANTIDAD) VALUES (?,?,?)");
                    ps.setInt(1, personaje.getIdPersonaje());
                    ps.setInt(2, item.getIdItem());
                    ps.setInt(3, 1);

                    ps.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }



        } else {
            System.out.println(personaje.getNombre()+" no tiene oro suficiente "+personaje.getOro()+" - "+item.getPrecio_oro());
        }
    }
}
