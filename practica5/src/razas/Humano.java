package razas;

public class Humano implements Raza{
    public Humano() {
    }

    //Sobreescribo los atributos con lo indicado en la practica

    @Override
    public String nombre() {
        return "Humano";
    }

    @Override
    public int fuerzaBase() {
        return 5;
    }

    @Override
    public int inteligenciaBase() {
        return 5;
    }

    @Override
    public int destrezaBase() {
        return 5;
    }

    @Override
    public int vidaBase() {
        return 100;
    }
}
