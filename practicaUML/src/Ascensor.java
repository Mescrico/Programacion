import java.util.ArrayList;

public class Ascensor extends Maquinaria {
    private String id_ascensor;
    private boolean vip;

    public Ascensor(String funcion, String id_ascensor, boolean vip) {
        super(funcion);
        this.id_ascensor = id_ascensor;
        this.vip = vip;
    }

    public void validacionBiometrica(int ordenLLegada, String dni) {
        ArrayList<String> dniPersonasAccedidas = new ArrayList<>();

        dniPersonasAccedidas.add(dni);
    }
}
