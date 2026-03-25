package rpg.model;

import java.util.ArrayList;
import java.util.List;

public class Personajes {
    private int idPersonaje;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private int id_raza;
    private int id_clase;
    private int id_ciudad_actual;
    private List<PersonajeHabilidad> inventario;
    private List<Habilidades> habilidades;

    public Personajes(int idPersonaje, String nombre, int nivel, int oro, int vida_actual, int id_raza, int id_clase, int id_ciudad_actual, List<Habilidades> habilidades, List<PersonajeHabilidad> inventario) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida_actual = vida_actual;
        this.oro = oro;
        this.id_raza = id_raza;
        this.id_clase = id_clase;
        this.id_ciudad_actual = id_ciudad_actual;
        this.habilidades = new ArrayList<>();
        this.inventario = new ArrayList<>();
    }
}
