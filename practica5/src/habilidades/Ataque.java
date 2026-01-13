package habilidades;

import modelo.Personaje;

public class Ataque implements Habilidades{

    public Ataque() {
    }

    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public int poder() {
        return 20;
    }

    @Override
    public int usosRestantes() {
        return -1;
    }

    @Override
    public void usar(Personaje atacante, Personaje objetivo) {
        int daño = (int) (Math.random()*poder()+(atacante.getDestreza()+atacante.getInteligencia()));
        objetivo.reducirVida(daño);
        System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
        System.out.println("-------------------------");
    }
}
