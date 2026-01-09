package habilidades;

public class DañoADistancia implements Habilidades{
    private int usos = 1;
    @Override
    public String nombre() {
        return "Daño a distancia";
    }

    @Override
    public int poder() {
        return 60;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }
}
