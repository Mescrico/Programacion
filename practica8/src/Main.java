import rpg.dao.*;
import rpg.model.Ciudades;
import rpg.model.Items;

public class Main {
    public static void main(String[] args) {
        PersonajeDAO a = new PersonajeDAO();
        ItemDAO b = new ItemDAO();
        CiudadesDAO c = new CiudadesDAO();
        HabilidadesDAO d = new HabilidadesDAO();
        RazasDAO e = new RazasDAO();
        ClasesrpgDAO f = new ClasesrpgDAO();

        a.cargarPersonajes();
        b.cargarItems();
        c.cargarCiudades();
        d.cargarHabilidades();
        e.cargarRazas();
        f.cargarClases();


        a.crearPersonaje();
    }
}