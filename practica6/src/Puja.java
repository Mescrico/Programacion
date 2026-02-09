public class Puja {
    private double cantidad;
    private String jugador;

    public Puja(double cantidad, String jugador) {
        this.jugador = jugador;
        this.cantidad = cantidad;
    }

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
                ", jugador='" + jugador + '\'' +
                '}';
    }
}
