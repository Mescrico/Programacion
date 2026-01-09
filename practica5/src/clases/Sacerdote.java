package clases;

import habilidades.CuraCuerpoACuerpo;
import habilidades.DañoADistancia;
import habilidades.DañoCuerpoACuerpo;
import habilidades.Habilidades;

import java.util.ArrayList;

public class Sacerdote implements Clase{

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
        listahabilidades.add(new CuraCuerpoACuerpo());
        listahabilidades.add(new DañoCuerpoACuerpo());
        listahabilidades.add(new DañoADistancia());
        return listahabilidades;
    }
}
