package modelo;

import clases.Clase;
import habilidades.Habilidades;
import razas.Raza;

import java.util.ArrayList;

public abstract class Personaje {
    private Clase clase;
    private Raza raza;
    private ArrayList<Habilidades> habilidades;
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vidaBase;

    public Personaje(Clase clase, Raza raza, int fuerza, int inteligencia, int destreza, int vidaBase) {
        this.clase = clase;
        this.raza = raza;
        this.habilidades = new ArrayList<>();
        this.fuerza = raza.fuerzaBase() + clase.bonoFuerza();
        this.inteligencia = raza.inteligenciaBase() + clase.bonoInteligencia();
        this.destreza = raza.destrezaBase() + clase.bonoDestreza();
        this.vidaBase = raza.vidaBase() + clase.vidaMaxima();
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public ArrayList<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }
}
