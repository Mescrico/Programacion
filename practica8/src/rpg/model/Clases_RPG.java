package rpg.model;

public class Clases_RPG {
    private int idClasesRPG;
    private String nombre;

    public Clases_RPG(int idClasesRPG, String nombre) {
        this.idClasesRPG = idClasesRPG;
        this.nombre = nombre;
    }

    public int getIdClasesRPG() {
        return idClasesRPG;
    }

    public void setIdClasesRPG(int idClasesRPG) {
        this.idClasesRPG = idClasesRPG;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Clases_RPG{" +
                "idClasesRPG=" + idClasesRPG +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
