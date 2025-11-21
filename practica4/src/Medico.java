public class Medico {
    private String dni;
    private String nombre;
    private int edad;
    private String sexo;
    private double sueldoBruto;
    private int añosInicio;
    private Areas areas;

    public Medico(String dni, String nombre, int edad, String sexo, int sueldoBruto, int añosInicio, Areas areas) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.sueldoBruto = sueldoBruto;
        this.añosInicio = añosInicio;
        this.areas = areas;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public int getAñosInicio() {
        return añosInicio;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public void setAñosInicio(int añosInicio) {
        this.añosInicio = añosInicio;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }



    public double calcularSueldoNeto(double retencion) {
        return this.sueldoBruto*retencion;
    }

    public int getAniosAntiguedad() {
        return java.time.Year.now().getValue() - this.añosInicio;
    }

    public double calcularImpuestosAnuales(double tasaImpositiva) {
        return this.sueldoBruto - (this.sueldoBruto*tasaImpositiva);
    }

    public boolean esMayorDeEdad(int mayoriaEdad) {
        if(mayoriaEdad >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public double proximoAumento(double porcentajeAumento, int aniosRequeridos) {
        if(getAniosAntiguedad() >= aniosRequeridos) {
            return sueldoBruto*porcentajeAumento;
        } else {
            return sueldoBruto;
        }
    }

    public void cambiarArea(Areas nuevaArea) {
        this.areas.disminuirMedico();
        this.setAreas(nuevaArea);
        this.areas.aumentarMedico();
    }
}
