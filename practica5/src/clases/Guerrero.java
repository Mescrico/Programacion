package clases;

import habilidades.*;

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
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
