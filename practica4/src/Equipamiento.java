public class Equipamiento {
    private String nombre;
    private int codigo;
    private int fechaAdquisicion;


    public Equipamiento(String nombre, int codigo, int fechaAdquisicion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(int fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }


    @Override
    public String toString() {
        return "Equipamiento{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", fechaAdquisicion=" + fechaAdquisicion +
                '}';
    }
}
