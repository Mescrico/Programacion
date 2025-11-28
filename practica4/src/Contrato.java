public class Contrato {
    //Creamos los atributos de la clase contrato
    private int fechaCreacion;
    private Medico medico;
    private Hospital hospital;

    //Creamos el constructor de la clase contrato
    public Contrato(int fechaCreacion, Medico medico, Hospital hospital) {
        this.fechaCreacion = fechaCreacion;
        this.medico = medico;
        this.hospital = hospital;
        //Agregamos en el hospital puesto el contrato creado
        this.hospital.agregarContrato(this);
    }

    //Creamos los getter y setter de los atributos

    public int getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    //Creamos las funciones que va a tener la clase contrato

    //Esta funcion necesita que se le introduzca una variable entera que será el año
    //Y la comparará para ver si los contratos de los médicos son de ese año
    public boolean esDeAnio(int anio) {
        return this.fechaCreacion == anio;
    }

    //Esta funcion devolverá los años que lleva desde la creación del contrato
    public int añosDesdeCreacion() {
        return java.time.Year.now().getValue() - this.fechaCreacion;
    }

    //Hacemos el paso  de parámetros a toString
    @Override
    public String toString() {
        return "Médico: "+medico.getNombre()+" Fecha creación: "+fechaCreacion+" Hospital: "+hospital.getNombre();
    }
}