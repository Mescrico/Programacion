package habilidades;

public class CuraCuerpoACuerpo implements Habilidades{
    private int usos = 3;
    private String nombre;

    public CuraCuerpoACuerpo(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
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
