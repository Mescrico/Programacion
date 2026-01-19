package habilidades;

import modelo.Personaje;

public class DañoCuerpoACuerpo implements Habilidades{
    //Creo 2 atributos, uno que es la cantidad de usos que tiene la habilidad, y el otro para el nombre de la habilidad
    private int usos = 5;
    private String nombre;

    //Creo el constructor que necesita que se le introduzca el nombre para ponerlo en la habilidad
    public DañoCuerpoACuerpo(String nombre) {
        this.nombre = nombre;
    }

    //Sobreescribo los atributos con lo indicado en la practica

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
        //Comprobamos si no le queda ningun uso
        if(usosRestantes() <= 0) {
            System.out.println("Ya no quedan más usos de "+atacante.getHabilidades().get(1).getNombre());
            System.out.println("-------------------------");
            return;
        }
        //Si la clase del atacante es alguna de las siguientes le daremos un bono
        if (atacante.getClase().getClass().getSimpleName().equals("Guerrero") || atacante.getClase().getClass().getSimpleName().equals("Paladin") || atacante.getClase().getClass().getSimpleName().equals("Monje") || atacante.getClase().getClass().getSimpleName().equals("Druida")) {
            //Restamos un uso
            usos--;

            //Calculamos el daño, que sera un numero aleatorio hasta el poder sumando la fuerza, a este numero le damos un bono del 20%
            int daño = (int) (((Math.random()*poder())+atacante.getFuerza()) * 1.20);

            //Llamamos a la funcion reducirVida con el daño
            objetivo.reducirVida(daño);

            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");

        } else { //Si la clase del atacante no es ninguna de las anteriores no le daremos el bono
            //Restamos un uso
            usos--;

            //Calculamos el daño con la misma formula de antes pero sin el bono
            int daño = (int) ((Math.random()*poder())+atacante.getFuerza());

            //LLamamos a la funcion reducirVida con el daño
            objetivo.reducirVida(daño);

            System.out.println(objetivo.getNombre()+" ha recibido "+daño+" puntos de daño");
            System.out.println("-------------------------");
        }

    }

    @Override
    public void reinicioUsos() {
        //Colocamos los usos iniciales
        this.usos = 5;
    }
}
