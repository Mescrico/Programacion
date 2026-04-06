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

    public int getIdCiudades() {
        return idCiudades;
    }

    public void setIdCiudades(int idCiudades) {
        this.idCiudades = idCiudades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel_minimo_acceso() {
        return nivel_minimo_acceso;
    }

    public void setNivel_minimo_acceso(int nivel_minimo_acceso) {
        this.nivel_minimo_acceso = nivel_minimo_acceso;
    }

    @Override
    public String toString() {
        return "Ciudades{" +
                "idCiudades=" + idCiudades +
                ", nombre='" + nombre + '\'' +
                ", nivel_minimo_acceso=" + nivel_minimo_acceso +
                '}';
    }
}
