package habilidades;

import modelo.Personaje;

public class DañoCuerpoACuerpo implements Habilidades{
    private int usos = 5;
    private String nombre;

    public DañoCuerpoACuerpo(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int poder() {
        return 35;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }



    @Override
    public void usar(Personaje atacante, Personaje objetivo) {
        if(usosRestantes() <= 0) {
            System.out.println("Ya no quedan más usos de "+atacante.getHabilidades().get(1).getNombre());
            System.out.println("-------------------------");
            return;
        }
        if (atacante.getClase().getClass().getSimpleName().equals("Guerrero") || atacante.getClase().getClass().getSimpleName().equals("Paladin") || atacante.getClase().getClass().getSimpleName().equals("Monje") || atacante.getClase().getClass().getSimpleName().equals("Druida")) {
            usos--;
            int daño = (int) ((Math.random()*poder())+(atacante.getFuerza() * 1.35));
            objetivo.reducirVida(daño);
            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");

        } else {
            usos--;
            int daño = (int) ((Math.random()*poder())+atacante.getFuerza());
            objetivo.reducirVida(daño);
            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");
        }

    }

    @Override
    public void reinicioUsos() {
        this.usos = 5;
    }
}
