public class Medico {
    //Creamos los atributos que va a tener la clase medico
    private String dni;
    private String nombre;
    private int edad;
    private String sexo;
    private double sueldoBruto;
    private int añosInicio;
    private Areas areas;
    private Direccion direccion;
    private Contrato contrato;

    //Creamos el constructor de la clase medico
    public Medico(String dni, String nombre, int edad, String sexo, int sueldoBruto, int añosInicio, Areas areas, Direccion direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.sueldoBruto = sueldoBruto;
        this.añosInicio = añosInicio;
        this.areas = areas;
        this.direccion = direccion;
        //Cuando creamos un medico aumentamos al area de ese medico el numero de medicos que hay
        this.areas.aumentarMedico();
        //Añadimos automaticamente un contrato nuevo para ese medico con los datos ya introducidos
        this.contrato = new Contrato(this.añosInicio, this, this.areas.getHospital());
    }

    //Creamos los getter y setter de los atributos

    public String getDni() {
        return dni;
    }

    public Contrato getContrato() {
        return contrato;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
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

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    //Creamos las funciones que va a tener la clase medico

    //Esta funcion va a calcular el sueldo neto de un medico en concreto multiplicando el sueldo bruto por el % de  retencion que se tiene que introducir
    public double calcularSueldoNeto(double retencion) {
        return this.sueldoBruto*retencion;
    }

    //Esta funcion va a devolver los años que lleva el medico en concreto activo
    public int getAniosAntiguedad() {
        return java.time.Year.now().getValue() - this.añosInicio;
    }

    //Esta funcion va a devolver los impuestos anuales del medico en concreto
    //Se tiene que introducir la tasa impositiva
    public double calcularImpuestosAnuales(double tasaImpositiva) {
        return this.sueldoBruto - (this.sueldoBruto*tasaImpositiva);
    }

    //Esta funcion es para ver si el medico en concreto es mayor de edad o no dependiendo de la variable introducida
    public boolean esMayorDeEdad(int mayoriaEdad) {
        return this.edad >= mayoriaEdad;
    }

    //Esta funcion se para calcular el proximo aumento que va a tener el medico en concreto
    //Se tiene que introducir el porcentaje de aumento que va a recibir y los años requeridos para conseguir ese aumento
    public double proximoAumento(double porcentajeAumento, int aniosRequeridos) {
        if(getAniosAntiguedad() >= aniosRequeridos) {
            return sueldoBruto*porcentajeAumento;
        } else {
            return sueldoBruto;
        }
    }

    //Esta funcion sirve para cambiar el area a un medico en concreto
    //Se tiene que introducir el area nueva del medico
    public void cambiarArea(Areas nuevaArea) {
        //Primero al area actual que esta el medico va a disminuirle el numero de medicos de ese area
        this.areas.disminuirMedico();
        //Luego va a sobreescribir su area con el area introducida
        this.setAreas(nuevaArea);
        //Y a esa area introducida va a aumentarle el numero de medicos de ese area
        this.areas.aumentarMedico();
    }

    //Hacemos el paso  de parámetros a toString
    @Override
    public String toString(){
        return "Nombre: "+nombre+" DNI: "+dni+" Edad: "+edad+" Sexo: "+sexo+" Sueldo bruto: "+sueldoBruto+" Años de inicio: "+añosInicio+" Áreas: "+areas.getNombre()+" Dirección: "+direccion;
    }
}