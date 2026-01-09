package razas;

public class Enano implements Raza{

    @Override
    public String nombre() {
        return "Enano";
    }

    @Override
    public int fuerzaBase() {
        return 7;
    }

    @Override
    public int inteligenciaBase() {
        return 4;
    }

    @Override
    public int destrezaBase() {
        return 4;
    }

    @Override
    public int vidaBase() {
        return 110;
    }
}
