package rpg.model;

public class Razas {
    private int idRaza;
    private String nombre;
    private int bonificador_vida;
    private int bonificador_fuerza;

    public Razas(int idRaza, String nombre, int bonificador_vida, int bonificador_fuerza) {
        this.idRaza = idRaza;
        this.nombre = nombre;
        this.bonificador_vida = bonificador_vida;
        this.bonificador_fuerza = bonificador_fuerza;
    }
}
