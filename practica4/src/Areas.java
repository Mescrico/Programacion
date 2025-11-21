public class Areas {
    private String nombre;
    private int identificador;
    private int planta;
    private Hospital hospital;
    private int numMedicos;

    public Areas(String nombre, int identificador, int planta, Hospital hospital) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.planta = planta;
        this.hospital = hospital;
        this.numMedicos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public int getNumMedicos() {
        return numMedicos;
    }

    public void setNumMedicos(int numMedicos) {
        this.numMedicos = numMedicos;
    }

    public void aumentarMedico() {
        this.numMedicos++;
    }

    public void disminuirMedico() {
        this.numMedicos--;
    }



    public void compararMedicos(Areas otraArea) {
        if(this.numMedicos > otraArea.numMedicos) {
            System.out.println("La área "+otraArea+" tiene menos médicos");
        } else if(this.numMedicos < otraArea.numMedicos) {
            System.out.println("La área "+otraArea+" tiene más médicos");
        } else {
            System.out.println("Las dos áreas tienen el mismo número de médicos");
        }
    }


}
