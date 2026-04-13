package rpg.logic;

import rpg.dao.*;
import rpg.model.*;
import rpg.ui.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
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

        m = new Menu();
    }
}
