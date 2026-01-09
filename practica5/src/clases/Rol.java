package clases;

public abstract class Rol {
    int bonoFuerza;
    int bonoInteligencia;
    int bonoDestreza;
    int vidaMaxima;

    public Rol(int bonoFuerza, int bonoInteligencia, int bonoDestreza, int vidaMaxima) {
        this.bonoFuerza = bonoFuerza;
        this.bonoInteligencia = bonoInteligencia;
        this.bonoDestreza = bonoDestreza;
        this.vidaMaxima = vidaMaxima;
    }

    public int getBonoFuerza() {
        return bonoFuerza;
    }

    public void setBonoFuerza(int bonoFuerza) {
        this.bonoFuerza = bonoFuerza;
    }

    public int getBonoInteligencia() {
        return bonoInteligencia;
    }

    public void setBonoInteligencia(int bonoInteligencia) {
        this.bonoInteligencia = bonoInteligencia;
    }

    public int getBonoDestreza() {
        return bonoDestreza;
    }

    public void setBonoDestreza(int bonoDestreza) {
        this.bonoDestreza = bonoDestreza;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }
}
