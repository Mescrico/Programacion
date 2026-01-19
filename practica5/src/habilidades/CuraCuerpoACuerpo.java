package habilidades;

import modelo.Personaje;

public class CuraCuerpoACuerpo implements Habilidades{
    //Creo 2 atributos, uno que es la cantidad de usos que tiene la habilidad, y el otro para el nombre de la habilidad
    private int usos = 3;
    private String nombre;

    //Creo el constructor que necesita que se le introduzca el nombre para ponerlo en la habilidad
    public CuraCuerpoACuerpo(String nombre) {
        this.nombre = nombre;
    }

    //Sobreescribo los atributos con lo indicado en la practica

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int poder() {
        return 30;
    }

    @Override
    public int usosRestantes() {
        return usos;
    }

    @Override
    public void usar(Personaje atacante, Personaje objetivo) {
        //Comprobamos primero si no le quedan usos
        if(usosRestantes() <= 0) {
            //Si no le quedan muestra el mensaje y vuelve a pedir que eliga la habilidad
            System.out.println("Ya no quedan más usos de "+atacante.getHabilidades().get(0).getNombre());
            System.out.println("-------------------------");
            return;
        }
        //Si el atacante es de alguna clase de las indicadas le damos un bono de curacion
        if (atacante.getClase().getClass().getSimpleName().equals("Sacerdote") || atacante.getClase().getClass().getSimpleName().equals("Druida") || atacante.getClase().getClass().getSimpleName().equals("Paladin") || atacante.getClase().getClass().getSimpleName().equals("Bardo") || atacante.getClase().getClass().getSimpleName().equals("Mago")) {
            //Comprobamos si el atacante ya tiene la vida al maximo
            //VidaBase es la vida actual, y vidaInicial la que se tiene al principio
            if(atacante.getVidaBase() == atacante.vidaInicial()) {
                System.out.println(atacante.getNombre()+" ya tiene la vida al máximo");
                System.out.println("-------------------------");
                return;
            }

            //Restamos un uso
            usos--;

            //Calculamos la curacion que va a recibir en un entero, le damos un bono del 20% de un numero aleatorio hasta el poder mas sumando la inteligencia
            int cantidadCuracion = (int) (((Math.random()*poder())+atacante.getInteligencia()) * 1.20);

            //Llamamos a la funcion curacion con la cantidad de curacion
            atacante.curacion(cantidadCuracion);

            System.out.println(atacante.getNombre()+" ha recibido "+cantidadCuracion+" puntos de vida");
            System.out.println("-------------------------");

        } else { //Si el atacante no es de ninguna clase de las anteriores no recibirá el bono
            //Comprobamos si el atacante ya tiene la vida al maximo
            if(atacante.getVidaBase() == atacante.vidaInicial()) {
                System.out.println(atacante.getNombre()+" ya tiene la vida al máximo");
                System.out.println("-------------------------");
                return;
            }

            //Restamos un uso
            usos--;

            //Calculamos la cantidad en un entero, esta vez sin el bono
            int cantidadCuracion = (int) ((Math.random()*poder())+(atacante.getInteligencia()));

            //Llamamos a la funcion curacion con la cantidad de curacion
            atacante.curacion(cantidadCuracion);

            System.out.println(atacante.getNombre()+" ha recibido "+cantidadCuracion+" puntos de vida");
            System.out.println("-------------------------");
        }
    }

    @Override
    public void reinicioUsos() {
        //Colocamos los usos iniciales
        this.usos = 3;
    }
}
