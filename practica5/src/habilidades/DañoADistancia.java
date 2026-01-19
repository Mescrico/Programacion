package habilidades;

import modelo.Personaje;

public class DañoADistancia implements Habilidades{
    //Creo los atributos de usos y del nombre que va a recibir la habilidad
    private int usos = 1;
    private String nombre;

    //Creo el constructor que necesita que se le introduzca el nombre para ponerlo en la habilidad
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

    //Sobreescribo los atributos con lo indicado en la practica

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
        //Comprobamos si no le quedan mas usos
        if(usosRestantes() <= 0) {
            System.out.println("Ya no quedan más usos de "+atacante.getHabilidades().get(2).getNombre());
            System.out.println("-------------------------");
            return;
        }
        //Si la clase del atacante es alguna de las siguientes le daremos un bono
        if (atacante.getClase().getClass().getSimpleName().equals("Picaro") || atacante.getClase().getClass().getSimpleName().equals("Mago") || atacante.getClase().getClass().getSimpleName().equals("Sacerdote") || atacante.getClase().getClass().getSimpleName().equals("Bardo") || atacante.getClase().getClass().getSimpleName().equals("Monje") ||atacante.getClase().getClass().getSimpleName().equals("Druida")) {

            //Restamos un uso
            usos--;

            //Calculamos el daño que es un entero, sera un numero aleatorio hasta el poder, mas el 20% de la destreza e inteligencia sumados
            int daño = (int) (Math.random()*poder()+(atacante.getDestreza()+atacante.getInteligencia()) * 1.20);

            //Llamamos a la funcion reducirVida con el daño
            objetivo.reducirVida(daño);

            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");
        } else { //Si la clase del atacante no es ninguna de las anteriores no le daremos el bono
            //Restamos un uso
            usos--;

            //Calculamos el daño que será un entero, con la misma formula que antes
            int daño = (int) (Math.random()*poder()+(atacante.getDestreza()+atacante.getInteligencia()));

            //Llamamos a la funcion reducirVida con el daño
            objetivo.reducirVida(daño);

            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");
        }
    }

    @Override
    public void reinicioUsos() {
        //Ponemos los usos iniciales
        this.usos = 1;
    }
}
