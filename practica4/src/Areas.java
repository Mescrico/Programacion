public class Areas {
    //Creamos los atributos de la clase area
    private String nombre;
    private String identificador;
    private int planta;
    private Hospital hospital;
    private int numMedicos;

    //Creamos el constructor de la clase area
    public Areas(String nombre, String identificador, int planta, Hospital hospital) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.planta = planta;
        this.hospital = hospital;
        //Al crear un area empezará con el numero de medicos en 0
        this.numMedicos = 0;
        //Agregamos en el hospital el area creada
        this.hospital.agregarArea(this);
    }

    //Creamos los getter y setter de los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
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

    //Creamos las funciones que va a tener la clase area

    //Esta funcion va a ir aumentando el numero de medicos en el area seleccionada
    public void aumentarMedico() {
        this.numMedicos++;
    }

    //Esta funcion va a ir disminuyendo el numero de medicos en el area seleccionada
    public void disminuirMedico() {
        this.numMedicos--;
    }

    //Esta funcion va a comparar los medicos de un area seleccionada con las de un area introducida
    public void compararMedicos(Areas otraArea) {
        //Estos ifs son para comprobar que area tiene mas medicos y dependiendo del resueltado muestra un mensaje u otro
        if(this.numMedicos > otraArea.numMedicos) {
            System.out.println("La área "+this.getNombre()+" tiene más médicos");
        } else if(this.numMedicos < otraArea.numMedicos) {
            System.out.println("La área "+otraArea.getNombre()+" tiene más médicos");
        } else {
            System.out.println("Las dos áreas tienen el mismo número de médicos");
        }
    }

    //Esta funcion sirve para calcular la capacidad de medicos que todavia pueden entrar, con el limite maximo introducido
    public int calcularCapacidadRestante(int capacidadMaxima) {
        return capacidadMaxima - this.numMedicos;
    }

    //Hacemos el paso  de parámetros a toString
    @Override
    public String toString(){
        return "Nombre: "+nombre+" Identificador: "+identificador+" Planta: "+planta+" Hospital: "+hospital.getNombre();
    }
}