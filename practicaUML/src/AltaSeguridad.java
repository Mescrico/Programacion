import java.util.HashSet;

public class AltaSeguridad extends Espacios{

    public AltaSeguridad(double tamaño) {
        super(tamaño);
    }

    public void validacionBiometrica(int ordenLlegada, String dni) {
        HashSet<String> dniPersonasAccedidas = new HashSet<>();

        dniPersonasAccedidas.add(dni);
    }
}
