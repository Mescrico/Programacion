package habilidades;

public class DañoCuerpoACuerpo implements Habilidades{
    private int usos = 5;

    @Override
    public String nombre() {
        return "Daño cuerpo a cuerpo";
    }

    @Override
    public int poder() {
        return 15;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }
}
