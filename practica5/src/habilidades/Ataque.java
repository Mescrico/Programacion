package habilidades;

import modelo.Personaje;

public class Ataque implements Habilidades{

    public Ataque() {
    }

    //Sobreescribo los atributos con los nombres correspondientes

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
        //Coloco que tiene -1 para que tenga infinitos usos
        return -1;
    }

    @Override
    public void usar(Personaje atacante, Personaje objetivo) {
        //El daño es un entero de un numero aleatorio hasta el poder
        int daño = (int) (Math.random()*poder());

        //Utilizamos la funcion de reducirVida usando el daño
        objetivo.reducirVida(daño);

        System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
        System.out.println("-------------------------");
    }

    @Override
    public void reinicioUsos() {
        //Lo dejo vacío ya que no es necesario en esta habilidad
    }
}
