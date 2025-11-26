import java.util.ArrayList;

public class Hospital {
    private String nombre;
    private String cif;
    private Direccion direccion;
    private ArrayList<Areas> areas;
    private ArrayList<Contrato> contrato;

    public Hospital (String nombre, String cif, Direccion direccion) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.areas = new ArrayList<>();
        this.contrato = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public ArrayList<Areas> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Areas> areas) {
        this.areas = areas;
    }


    public void agregarArea(Areas areas) {
        this.areas.add(areas);
    }

    public void agregarContrato(Contrato contrato) {
        this.contrato.add(contrato);
    }

    public int getNumeroTotalMedicos() {
        int numero = 0;
        for (int i = 0; i < areas.size(); i++) {
            numero += this.areas.get(i).getNumMedicos();

        }
        return numero;
    }

    public double getProporcionMedicosArea(String idArea) {
        for (int i = 0; i < areas.size(); i++) {
            if(this.areas.get(i).getIdentificador().equals(idArea)) {
                return (double) this.areas.get(i).getNumMedicos() / (double) getNumeroTotalMedicos();
            }
        }
        return 0;
    }

    public boolean existeArea(String idArea) {
        for (int i = 0; i < areas.size(); i++) {
            if(this.areas.get(i).getIdentificador().equals(idArea)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nombre: "+this.nombre+" CIF: "+cif+" Dirección: "+direccion;
    }
}