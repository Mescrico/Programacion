package clases;

import habilidades.*;

import java.util.ArrayList;

public class Sacerdote implements Clase{
    public Sacerdote() {
    }

    @Override
    public int bonoFuerza() {
        return 0;
    }

    @Override
    public int bonoInteligencia() {
        return 3;
    }

    @Override
    public int bonoDestreza() {
        return 0;
    }

    @Override
    public int vidaMaxima() {
        return 95;
    }

    @Override
    public ArrayList<Habilidades> habilidades() {
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Sanación Bendita"));
        listahabilidades.add(new DañoCuerpoACuerpo("Golpe de Fe"));
        listahabilidades.add(new DañoADistancia("Rayo Sagrado"));
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
