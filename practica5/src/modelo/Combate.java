package modelo;

public class Combate {
    private Personaje personaje1;
    private Personaje personaje2;

    public Combate() {

    }

    public void combate(Personaje personaje1, Personaje personaje2) {
        System.out.println("INICIA " + personaje1.getNombre());

    }
}
//Crear lista personajes