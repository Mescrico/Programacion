public class Edificio {
    private String Nombre;
    private String Direccion;

    public Edificio(String nombre, String direccion) {
        Nombre = nombre;
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}