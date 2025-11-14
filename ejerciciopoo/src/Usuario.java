public class Usuario {
    //Atributos privados
    private String nombre;

    private String apellidos;

    private String codigoPostal;

    private String direccion;

    private String email;

    private String contrasena;

    //Constructor
    public Usuario(String nom, String ape, String cp, String dir, String em, String cont) {
        nombre = nom;
        apellidos = ape;
        codigoPostal = cp;
        direccion = dir;
        email = em;
        contrasena = cont;
    }

    //Metodos get y set

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getEmail() {
        return email;
    }
    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        if(email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Error: Email inválido. No contiene @");
        }
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    //Metodo de autenticacion
    public boolean checkUsuario(String email, String password) {
        if(email.equals(this.email) && password.equals((this.contrasena))) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo de representacion
    public String toString() {
        return "Nombre: "+this.nombre+" Apellidos: "+this.apellidos+" Codigo Postal: "+this.codigoPostal+" Direccion: "+this.direccion+" Email: "+this.email;
    }
}
