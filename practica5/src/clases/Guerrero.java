package clases;

import habilidades.*;

import java.util.ArrayList;

public class Guerrero implements Clase{
    public Guerrero() {
    }

    //Sobreescribo los atributos con lo indicado en la practica

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
        //Creo un nuevo arraylist y le añado las habilidades con los nombres correspondientes a cada clase
        ArrayList<Habilidades> listahabilidades = new ArrayList<>();
        listahabilidades.add(new CuraCuerpoACuerpo("Grito de Guerra Revitalizante"));
        listahabilidades.add(new DañoCuerpoACuerpo("Hachazo Brutal"));
        listahabilidades.add(new DañoADistancia("Lanzamiento de Hacha"));
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
