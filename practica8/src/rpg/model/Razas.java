package rpg.model;

public class Razas {
    private int idRaza;
    private String nombre;
    private int bonificador_vida;
    private int bonificador_fuerza;

    public Razas(int idRaza, String nombre, int bonificador_vida, int bonificador_fuerza) {
        this.idRaza = idRaza;
        this.nombre = nombre;
        this.bonificador_vida = bonificador_vida;
        this.bonificador_fuerza = bonificador_fuerza;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBonificador_vida() {
        return bonificador_vida;
    }

    public void setBonificador_vida(int bonificador_vida) {
        this.bonificador_vida = bonificador_vida;
    }

    public int getBonificador_fuerza() {
        return bonificador_fuerza;
    }

    public void setBonificador_fuerza(int bonificador_fuerza) {
        this.bonificador_fuerza = bonificador_fuerza;
    }

    @Override
    public String toString() {
        return "Razas{" +
                "idRaza=" + idRaza +
                ", nombre='" + nombre + '\'' +
                ", bonificador_vida=" + bonificador_vida +
                ", bonificador_fuerza=" + bonificador_fuerza +
                '}';
    }
}
