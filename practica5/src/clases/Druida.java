package clases;

import habilidades.*;

import java.util.ArrayList;

public class Druida implements Clase{
    public Druida() {
    }

    @Override
    public int bonoFuerza() {
        return 2;
    }

    @Override
    public int bonoInteligencia() {
        return 1;
    }

    @Override
    public int bonoDestreza() {
        return 0;
    }

    @Override
    public int vidaMaxima() {
        return 100;
    }

    @Override
    public ArrayList<Habilidades> habilidades() {
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Toque de la Naturaleza"));
        listahabilidades.add(new DañoCuerpoACuerpo("Garra Salvaje"));
        listahabilidades.add(new DañoADistancia("Espinas Proyectadas"));
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
