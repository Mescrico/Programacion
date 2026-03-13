package model;

import handler.DatoInvalidoException;
import utils.LoggerCustom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private String nombre;
    private String raza;
    private int nivel;
    private List<String> equipoIds;
    private String ciudad;

    public Personaje(String nombre, String raza, int nivel, List<String> equipoIds, String ciudad) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.equipoIds = equipoIds;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
       this.nivel = nivel;
    }

    public List<String> getEquipoIds() {
        return equipoIds;
    }

    public void setEquipoIds(List<String> equipoIds) {
        this.equipoIds = equipoIds;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
