package rpg.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Personajes {
    private int idPersonaje;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private Razas raza;
    private Clases_RPG clase;
    private Ciudades ciudad;

    private List<HashMap<Items, Integer>> inventario;
    private List<Habilidades> habilidades;

    public Personajes(int idPersonaje, String nombre, int nivel, int oro, int vida_actual, Razas raza, Clases_RPG clase, Ciudades ciudad) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida_actual = vida_actual;
        this.oro = oro;
        this.raza = raza;
        this.clase = clase;
        this.ciudad = ciudad;

        this.habilidades = new ArrayList<>();
        this.inventario = new ArrayList<HashMap<Items, Integer>>();
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public Razas getRaza() {
        return raza;
    }

    public void setRaza(Razas raza) {
        this.raza = raza;
    }

    public Clases_RPG getClase() {
        return clase;
    }

    public void setClase(Clases_RPG clase) {
        this.clase = clase;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public void addInventario(HashMap<Items, Integer> i) {
        inventario.add(i);
    }
    public List<HashMap<Items, Integer>> getInventario() {
        return inventario;
    }

    public void setInventario(List<HashMap<Items, Integer>> inventario) {
        this.inventario = inventario;
    }

    public void addHabilidad(Habilidades h) {
        habilidades.add(h);
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "idPersonaje=" + idPersonaje +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", oro=" + oro +
                ", vida_actual=" + vida_actual +
                ", raza=" + raza +
                ", clase=" + clase +
                ", ciudad=" + ciudad +
                ", inventario=" + inventario +
                ", habilidades=" + habilidades +
                '}';
    }
}
