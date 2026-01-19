package clases;

import habilidades.*;

import java.util.ArrayList;

public class Paladin implements Clase{
    public Paladin() {
    }

    //Sobreescribo los atributos con lo indicado en la practica

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
        return 115;
    }

    @Override
    public ArrayList<Habilidades> habilidades() {
        //Creo un nuevo arraylist y le añado las habilidades con los nombres correspondientes a cada clase
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Toque de Luz Sagrada"));
        listahabilidades.add(new DañoCuerpoACuerpo("Martillazo Divino"));
        listahabilidades.add(new DañoADistancia("Lanza de Fe"));
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
