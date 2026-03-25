package rpg.model;

public class Habilidades {
    private int idHabilidades;
    private String nombre;
    private int daño_base;
    private int usos_maximos;
    private int id_clase;

    public Habilidades(int idHabilidades, String nombre, int daño_base, int usos_maximos, int id_clase) {
        this.idHabilidades = idHabilidades;
        this.nombre = nombre;
        this.daño_base = daño_base;
        this.usos_maximos = usos_maximos;
        this.id_clase = id_clase;
    }
}
