package rpg.model;

public class Items {
    private int idItem;
    private String nombre;
    private String tipo;
    private int precio_oro;
    private int bonificador_ataque;
    private int bonificador_defensa;

    public Items(int idItem, String nombre, String tipo, int precio_oro, int bonificador_ataque, int bonificador_defensa) {
        this.idItem = idItem;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio_oro = precio_oro;
        this.bonificador_ataque = bonificador_ataque;
        this.bonificador_defensa = bonificador_defensa;
    }
}
