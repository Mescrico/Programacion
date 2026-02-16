public class Oficinas extends AltaSeguridad{
    private int numOficina;
    private String nombre;

    public Oficinas(double tamaño, String nombre, int numOficina) {
        super(tamaño);
        this.nombre = nombre;
        this.numOficina = numOficina;
    }

    public int getNumOficina() {
        return numOficina;
    }

    public void setNumOficina(int numOficina) {
        this.numOficina = numOficina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
