package habilidades;

public class DañoADistancia implements Habilidades{
    private int usos = 1;
    private String nombre;

    public DañoADistancia(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
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
