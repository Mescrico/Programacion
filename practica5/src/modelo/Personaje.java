package modelo;

import clases.Clase;
import habilidades.Ataque;
import habilidades.Habilidades;
import razas.Raza;

import java.util.ArrayList;

public class Personaje {
    //Creo los atributos
    private String nombre;
    private Clase clase;
    private Raza raza;
    private ArrayList<Habilidades> habilidades;
    private int fuerza;
    private int inteligencia;
    private int destreza;
    //vidaBase sera la vida actual
    private int vidaBase;
    //vidaMaxima sera la vida maxima posible
    private int vidaMaxima;

    //Pedimos el nombre, la clase y la raza
    public Personaje(String nombre, Clase clase, Raza raza) {
        this.nombre = nombre;
        this.clase = clase;
        this.raza = raza;

        //Creamos un arraylist de habilidades
        this.habilidades = new ArrayList<>();

        //Al arraylist de habilidades le añadimos las habilidades de la clase
        habilidades.addAll(clase.habilidades());

        //La fuerza es la suma de los puntos de fuerza de raza y clase
        this.fuerza = raza.fuerzaBase() + clase.bonoFuerza();
        //La inteligencia es la suma de los puntos de inteligencia de raza y clase
        this.inteligencia = raza.inteligenciaBase() + clase.bonoInteligencia();
        //La destreza es la suma de los puntos de destreza de raza y clase
        this.destreza = raza.destrezaBase() + clase.bonoDestreza();

        //La vidaBase sera la suma de los puntos de vida de raza y clase
        this.vidaBase = raza.vidaBase() + clase.vidaMaxima();
        //La vidaMaxima sera la suma de los puntos de vida de raza y clase
        this.vidaMaxima = raza.vidaBase() + clase.vidaMaxima();
    }

    //Creamos el metodo de vidaInicial que sera la vida que tiene el personaje sumado raza y clase
    public int vidaInicial() {
        //Aunque en una ponga vidaBase y en otra vidaMaxima las dos son vidas "bases" independientes que se suman
        return raza.vidaBase() + clase.vidaMaxima();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    //Creamos el metodo reducirVida que necesita el daño
    public void reducirVida(int daño) {
        //Calculamos la vida nueva con la vida actual menos el daño
        int vidaNueva = this.vidaBase - daño;

        //Si la vidaNueva es negativa la colocamos en 0
        if(vidaNueva < 0) {
            vidaNueva = 0;
        }

        //A la vida actual la igualamos con la vidaNueva
        this.setVidaBase(vidaNueva);
    }

    //Creamos el metodo curacion que necesita la cantidad
    public void curacion(int cantidad) {
        //Calculamos la vida nueva con la vida actual mas la cantidad
        int vidaNueva = this.vidaBase + cantidad;

        //Si la vidaNueva supera a la vidaMaxima
        if(vidaNueva > vidaMaxima) {
            //Igualamos la vida actual a la vidaMaxima
            this.vidaBase = vidaMaxima;
        } else { //En caso contrario
            //Igualamos la vida actual a la vidaNueva
            this.vidaBase = vidaNueva;
        }
    }

    //Creamos el metodo reinicio para reiniciar la vida y los usos
    public void reinicio() {
        //Reiniciamos la vida actual a la vidaMaxima
        this.setVidaBase(vidaMaxima);
        //Creamos un bucle para recorrer las habilidades y con el metodo reinicioUsos reiniciamos sus usos
        for (int i = 0; i < habilidades.size(); i++) {
            habilidades.get(i).reinicioUsos();
        }
    }

    public boolean tieneUsos() {
        for (int i = 0; i < habilidades.size(); i++) {
            if(habilidades.get(i).usosRestantes() > 0) {
                return true;
            }
        }
        return false;
    }


}
