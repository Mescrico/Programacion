package clases;

import habilidades.*;

import java.util.ArrayList;

public class Bardo implements Clase{
    public Bardo() {
    }

    //Sobreescribo los atributos con lo indicado en la practica

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
        return 90;
    }

    @Override
    public ArrayList<Habilidades> habilidades() {
        //Creo un nuevo arraylist y le añado las habilidades con los nombres correspondientes a cada clase
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Canto Sanador"));
        listahabilidades.add(new DañoCuerpoACuerpo("Ritmo Impactante"));
        listahabilidades.add(new DañoADistancia("Flecha Musicalno"));
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
