package rpg.model;

public class Ciudades {
    private int idCiudades;
    private String nombre;
    private int nivel_minimo_acceso;

    public Ciudades(int idCiudades, String nombre, int nivel_minimo_acceso) {
        this.idCiudades = idCiudades;
        this.nombre = nombre;
        this.nivel_minimo_acceso = nivel_minimo_acceso;
    }
}
