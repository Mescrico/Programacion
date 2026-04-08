package rpg.model;

import java.util.ArrayList;

public class Clases_RPG {
    private int idClasesRPG;
    private String nombre;
    private ArrayList<Habilidades> listahabilidades;

    public Clases_RPG(int idClasesRPG, String nombre) {
        this.idClasesRPG = idClasesRPG;
        this.nombre = nombre;
        this.listahabilidades = new ArrayList<>();
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

    public void addListahabilidades(Habilidades h) {
        listahabilidades.add(h);
    }

    public ArrayList<Habilidades> getListahabilidades() {
        return listahabilidades;
    }

    public void setListahabilidades(ArrayList<Habilidades> listahabilidades) {
        this.listahabilidades = listahabilidades;
    }

    @Override
    public String toString() {
        return "Clases_RPG{" +
                "idClasesRPG=" + idClasesRPG +
                ", nombre='" + nombre + '\'' +
                ", listahabilidades=" + listahabilidades.size() +
                '}';
    }
}
