package clases;

import habilidades.CuraCuerpoACuerpo;
import habilidades.DañoADistancia;
import habilidades.DañoCuerpoACuerpo;
import habilidades.Habilidades;

import java.util.ArrayList;

public class Guerrero implements Clase{

    @Override
    public int bonoFuerza() {
        return 3;
    }

    @Override
    public int bonoInteligencia() {
        return 0;
    }

    @Override
    public int bonoDestreza() {
        return 0;
    }

    @Override
    public int vidaMaxima() {
        return 120;
    }

    @Override
    public ArrayList<Habilidades> habilidades() {
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Grito de Guerra Revitalizante"));
        listahabilidades.add(new DañoCuerpoACuerpo("Hachazo Brutal"));
        listahabilidades.add(new DañoADistancia("Lanzamiento de Hacha"));
        return listahabilidades;
    }
}
