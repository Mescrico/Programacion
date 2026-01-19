package habilidades;

import modelo.Personaje;

public class DañoADistancia implements Habilidades{
    private int usos = 1;
    private String nombre;

    public DañoADistancia(String nombre) {
        this.nombre = nombre;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int poder() {
        return 65;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }

    @Override
    public void usar(Personaje atacante, Personaje objetivo) {
        if(usosRestantes() <= 0) {
            System.out.println("Ya no quedan más usos de "+atacante.getHabilidades().get(2).getNombre());
            System.out.println("-------------------------");
            return;
        }
        if (atacante.getClase().getClass().getSimpleName().equals("Picaro") || atacante.getClase().getClass().getSimpleName().equals("Mago") || atacante.getClase().getClass().getSimpleName().equals("Sacerdote") || atacante.getClase().getClass().getSimpleName().equals("Bardo") || atacante.getClase().getClass().getSimpleName().equals("Monje") ||atacante.getClase().getClass().getSimpleName().equals("Druida")) {
            usos--;
            int daño = (int) (Math.random()*poder()+(atacante.getDestreza()+atacante.getInteligencia()) * 1.35);
            objetivo.reducirVida(daño);
            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");
        } else {
            usos--;
            int daño = (int) (Math.random()*poder()+(atacante.getDestreza()+atacante.getInteligencia()));
            objetivo.reducirVida(daño);
            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");
        }
    }

    @Override
    public void reinicioUsos() {
        this.usos = 1;
    }
}
