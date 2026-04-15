package rpg.model;

import java.util.Objects;

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

    public int getIdHabilidades() {
        return idHabilidades;
    }

    public void setIdHabilidades(int idHabilidades) {
        this.idHabilidades = idHabilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño_base() {
        return daño_base;
    }

    public void setDaño_base(int daño_base) {
        this.daño_base = daño_base;
    }

    public int getUsos_maximos() {
        return usos_maximos;
    }

    public void setUsos_maximos(int usos_maximos) {
        this.usos_maximos = usos_maximos;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habilidades that = (Habilidades) o;
        return idHabilidades == that.idHabilidades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHabilidades);
    }

    @Override
    public String toString() {
        return "Habilidades{" +
                "idHabilidades=" + idHabilidades +
                ", nombre='" + nombre + '\'' +
                ", daño_base=" + daño_base +
                ", usos_maximos=" + usos_maximos +
                ", id_clase=" + id_clase +
                '}';
    }
}
