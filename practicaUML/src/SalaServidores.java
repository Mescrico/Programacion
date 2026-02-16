public class SalaServidores extends AltaSeguridad{
    private int numSala;
    private String nombre;

    public SalaServidores(double tamaño, int numSala, String nombre) {
        super(tamaño);
        this.numSala = numSala;
        this.nombre = nombre;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
