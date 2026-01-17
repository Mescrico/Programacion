package habilidades;

import modelo.Personaje;

public class CuraCuerpoACuerpo implements Habilidades{
    private int usos = 3;
    private String nombre;

    public CuraCuerpoACuerpo(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int poder() {
        return 40;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }

    @Override
    public void usar(Personaje atacante, Personaje objetivo) {
        if(usosRestantes() <= 0) {
            System.out.println("Ya no quedan más usos de "+atacante.getHabilidades().get(0).getNombre());
            System.out.println("-------------------------");
            return;
        }
        if (atacante.getClase().getClass().getSimpleName().equals("Sacerdote") || atacante.getClase().getClass().getSimpleName().equals("Druida") || atacante.getClase().getClass().getSimpleName().equals("Paladin") || atacante.getClase().getClass().getSimpleName().equals("Bardo") || atacante.getClase().getClass().getSimpleName().equals("Mago")) {
            if(atacante.getVidaBase() == atacante.vidaInicial()) {
                System.out.println(atacante.getNombre()+" ya tiene la vida al máximo");
                System.out.println("-------------------------");
                return;
            }
            usos--;
            int cantidadCuracion = (int) (Math.random()*poder()+atacante.getInteligencia() * 1.35);
            atacante.curacion(cantidadCuracion);
            System.out.println(atacante.getNombre()+" ha recibido "+cantidadCuracion+" puntos de vida");
            System.out.println("-------------------------");

        } else {
            if(atacante.getVidaBase() == atacante.vidaInicial()) {
                System.out.println(atacante.getNombre()+" ya tiene la vida al máximo");
                System.out.println("-------------------------");
                return;
            }
            usos--;
            int cantidadCuracion = (int) (Math.random()*poder()+atacante.getInteligencia());
            atacante.curacion(cantidadCuracion);
            System.out.println(atacante.getNombre()+" ha recibido "+cantidadCuracion+" puntos de vida");
            System.out.println("-------------------------");
        }
    }

    @Override
    public void reinicioUsos() {
        this.usos = 3;
    }
}
