package rpg.model;

public class PersonajeHabilidad {
    private int id_personaje;
    private int id_habilidad;
    private boolean equipada_combate;

    public PersonajeHabilidad(int id_personaje, int id_habilidad, boolean equipada_combate) {
        this.id_personaje = id_personaje;
        this.id_habilidad = id_habilidad;
        this.equipada_combate = equipada_combate;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public int getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(int id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public boolean isEquipada_combate() {
        return equipada_combate;
    }

    public void setEquipada_combate(boolean equipada_combate) {
        this.equipada_combate = equipada_combate;
    }

    @Override
    public String toString() {
        return "PersonajeHabilidad{" +
                "id_personaje=" + id_personaje +
                ", id_habilidad=" + id_habilidad +
                ", equipada_combate=" + equipada_combate +
                '}';
    }
}
