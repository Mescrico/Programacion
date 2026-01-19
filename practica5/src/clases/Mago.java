package clases;

import habilidades.*;

import java.util.ArrayList;

public class Mago implements Clase{
    public Mago() {
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
        listahabilidades.add(new CuraCuerpoACuerpo("Regeneración Arcana"));
        listahabilidades.add(new DañoCuerpoACuerpo("Descarga Impactante"));
        listahabilidades.add(new DañoADistancia("Proyectil Arcano"));
        listahabilidades.add(new Ataque());
        return listahabilidades;
    }
}
