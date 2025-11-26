public class Contrato {
    private int fechaCreacion;
    private Medico medico;
    private Hospital hospital;

    public Contrato(int fechaCreacion, Medico medico, Hospital hospital) {
        this.fechaCreacion = fechaCreacion;
        this.medico = medico;
        this.hospital = hospital;
    }

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

    public boolean esDeAnio(int anio) {
        return this.fechaCreacion == anio;
    }

    public int añosDesdeCreacion() {
        return java.time.Year.now().getValue() - this.fechaCreacion;
    }

    @Override
    public String toString() {
        return "Médico: "+medico.getNombre()+" Fecha creación: "+fechaCreacion+" Hospital: "+hospital.getNombre();
    }
}