package clases;

import habilidades.*;

import java.util.ArrayList;

public class Picaro implements Clase{
    public Picaro() {
    }

    //Sobreescribo los atributos con lo indicado en la practica

    @Override
    public int bonoFuerza() {
        return 0;
    }

    @Override
    public int bonoInteligencia() {
        return 0;
    }

    @Override
    public int bonoDestreza() {
        return 3;
    }

    @Override
    public int vidaMaxima() {
        return 105;
    }

    @Override
    public ArrayList<Habilidades> habilidades() {
        //Creo un nuevo arraylist y le añado las habilidades con los nombres correspondientes a cada clase
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Vendaje Rápido"));
        listahabilidades.add(new DañoCuerpoACuerpo("Puñalada Precisa"));
        listahabilidades.add(new DañoADistancia("Dardo Envenenado"));
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
