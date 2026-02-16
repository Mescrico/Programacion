public class Planta {
    private int NumPlanta;
    private String especialista;

    public Planta(int numPlanta, String especialista) {
        NumPlanta = numPlanta;
        this.especialista = especialista;
    }

    public int getNumPlanta() {
        return NumPlanta;
    }

    public void setNumPlanta(int numPlanta) {
        NumPlanta = numPlanta;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }
}
