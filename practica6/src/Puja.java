public class Puja {
    //Creamos la clase y le añadimos los 2 atributos de cantidad pujada y el nombre del jugador
    private double cantidad;
    private String jugador;

    //Hacemos el constructor
    public Puja(double cantidad, String jugador) {
        this.jugador = jugador;
        this.cantidad = cantidad;
    }

    //Y los getter y setter

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Puja{" +
                "cantidad=" + cantidad +
                ", jugador='" + jugador +
                "'}";
    }
}
