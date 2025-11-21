import java.awt.geom.Area;
import java.util.ArrayList;

public class Hospital {
    private String nombre;
    private String cif;
    private ArrayList<Areas> areas;

    public Hospital (String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.areas = new ArrayList<>();
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

    public ArrayList<Areas> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Areas> areas) {
        this.areas = areas;
    }


    public void agregarArea(Areas areas) {
        this.areas.add(areas);
    }
}
