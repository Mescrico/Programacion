package razas;

public class Elfo implements Raza {

    @Override
    public String nombre() {
        return "Elfo";
    }

    @Override
    public int fuerzaBase() {
        return 4;
    }

    @Override
    public int inteligenciaBase() {
        return 6;
    }

    @Override
    public int destrezaBase() {
        return 7;
    }

    @Override
    public int vidaBase() {
        return 90;
    }
}
