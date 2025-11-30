import java.util.ArrayList;

public class Hospital {
    //Creamos los atributos privados y los arraylist de areas y contratos del objeto hospital
    private String nombre;
    private String cif;
    private Direccion direccion;
    private ArrayList<Areas> areas;
    private ArrayList<Contrato> contrato;

    //Creamos el constructor del objeto hospital
    public Hospital (String nombre, String cif, Direccion direccion) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.areas = new ArrayList<>();
        this.contrato = new ArrayList<>();
    }

    //Creamos los getter y setter

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

    //Creamos las funciones que va a tener el objeto hospital

    //Esta funcion agrega el area seleccionada al hospital seleccionado
    public void agregarArea(Areas areas) {
        this.areas.add(areas);
    }

    //Esta funcion agrega el contrato seleccionado al hospital seleccionado
    public void agregarContrato(Contrato contrato) {
        this.contrato.add(contrato);
    }

    //Esta funcion devuelve el numero total de medicos en todos los areas
    public int getNumeroTotalMedicos() {
        //Inicializamos la varible de numero que contara el numero total de medicos
        int numero = 0;
        //Creamos el bucle que tendra el tamaño de las areas totales
        for (int i = 0; i < areas.size(); i++) {
            //En cada iteracion va a ir sumando el numero de medicos de cada area
            numero += this.areas.get(i).getNumMedicos();

        }
        return numero;
    }

    //Esta funcion devuelve la proporcion de medicos de un area seleccionada respecto al numero de medicos totales en formato 0-1
    public double getProporcionMedicosArea(String idArea) {
        //Creamos el bucle que recorrera todas las areas
        for (int i = 0; i < areas.size(); i++) {
            //Buscamos que el idArea introducido exista en algun area
            if(this.areas.get(i).getIdentificador().equals(idArea)) {
                //Si existe devuelve la proporcion de esa respecto al total de medicos
                return (double) this.areas.get(i).getNumMedicos() / (double) getNumeroTotalMedicos();
            }
        }
        //Si no existe devuelve 0
        return 0;
    }

    //Creamos la funcion que comprobará si existe un área introducida
    public boolean existeArea(String idArea) {
        //Creamos el bucle que recorrera todas las areas
        for (int i = 0; i < areas.size(); i++) {
            //Si la encuentra en algun area devuelve true
            if(this.areas.get(i).getIdentificador().equals(idArea)) {
                return true;
            }
        }
        //Si no la encuentro devuelve false
        return false;
    }

    //Hacemos el paso  de parámetros a toString
    @Override
    public String toString() {
        return "Nombre: "+this.nombre+" CIF: "+cif+" Dirección: "+direccion;
    }
}