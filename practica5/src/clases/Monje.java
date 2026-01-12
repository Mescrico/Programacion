package clases;

import habilidades.CuraCuerpoACuerpo;
import habilidades.DañoADistancia;
import habilidades.DañoCuerpoACuerpo;
import habilidades.Habilidades;

import java.util.ArrayList;

public class Monje implements Clase{

    @Override
    public int bonoFuerza() {
        return 2;
    }

    @Override
    public int bonoInteligencia() {
        return 0;
    }

    @Override
    public int bonoDestreza() {
        return 1;
    }

    @Override
    public int vidaMaxima() {
        return 110;
    }

    @Override
    public ArrayList<Habilidades> habilidades() {
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Palma Restauradora"));
        listahabilidades.add(new DañoCuerpoACuerpo("Puño del Dragón"));
        listahabilidades.add(new DañoADistancia("Onda de Chi"));
        return listahabilidades;
    }
}
