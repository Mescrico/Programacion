package habilidades;

public class CuraCuerpoACuerpo implements Habilidades{
    private int usos = 3;
    @Override
    public String nombre() {
        return "Cura cuerpo a cuerpo";
    }

    @Override
    public int poder() {
        return 25;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }
}
