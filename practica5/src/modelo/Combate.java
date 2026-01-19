package modelo;

import habilidades.Ataque;
import habilidades.Habilidades;

import java.util.Scanner;

public class Combate {
    //LLamo a 2 personajes
    private Personaje personaje1;
    private Personaje personaje2;

    public Combate() {
    }

    //Creo el metodo de acabado
    public boolean acabado() {
        //Si uno de los dos personajes tiene la vida actual a 0 o inferior devuelve verdadero
        if(this.personaje1.getVidaBase() <= 0 || this.personaje2.getVidaBase() <= 0) {
            return true;
        } else { //En caso contrario devuelve falso
            return false;
        }
    }

    //Creo el metodo combate, que necesita que le pasen 2 personajes
    public void combate(Personaje p1, Personaje p2) {
        //Primero llamamos al metodo reinicio y le reiniciamos la vida y usos
        p1.reinicio();
        p2.reinicio();

        Scanner s = new Scanner(System.in);
        //Pongo que los personajes pasados desde el metodo sean los que he llamado a la clase
        this.personaje1 = p1;
        this.personaje2 = p2;

        //Inicia el turno el jugador1
        System.out.println("INICIA " + personaje1.getNombre());

        //Mientras no haya acabado hacemos lo siguiente
        do{
            //Mostramos el nombre, vida actual y vida maxima de cada jugador
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p1.getNombre()+" SELECCIONA UNA OPCION");
            //Llamo a un boolean y a un int para la opcion
            boolean elegir;
            int opcion;
            //Mientras que no se haya elegido correctamente hacemos lo siguiente
            do {
                elegir = false;
                System.out.println("-------------------------");
                System.out.println("1.- Atacar");
                System.out.println("2.- Habilidad");
                System.out.println("-------------------------");
                opcion = s.nextInt();
                s.nextLine();

                //Si la opcion es 2 y al jugador1 no le quedan usos de ninguna habilidad volvemos a mostrar el menu
                if(opcion == 2 && !p1.tieneUsos()) {
                    System.out.println("No quedan más usos de ninguna habilidad");
                    continue;
                }
                //Si la opcion es 0 o menor, o mayor que 2 pedimos que elija una opcion valida
                if(opcion <= 0 || opcion > 2) {
                    System.out.println("Elige una opción válida");
                } else { //En caso contrario hacemos lo siguiente
                    //Creamos un switch case con lo que hara el programa segun la eleccion
                    switch (opcion) {
                        //En el caso 1 el jugador atacara al otro
                        case 1:
                            p1.getHabilidades().get(3).usar(p1, p2);
                            break;
                        //En el caso 2 pedimos que elija que habilidad usar
                        case 2:
                            System.out.println("-------------------------");
                            System.out.println("ELIGE LA HABILIDAD");
                            //Llamo a un booleano y a un int para la opcion
                            boolean elegir2;
                            int opcion2;
                            //Hacemos lo siguiente mientras no haya elegido correctamente
                            do {
                                elegir2 = false;

                                //Mostramos la lista de habilidades con sus nombres y usos restantes
                                System.out.println("-------------------------");
                                System.out.println("1.- "+p1.getHabilidades().get(1).getNombre()+" "+p1.getHabilidades().get(1).usosRestantes());
                                System.out.println("2.- "+p1.getHabilidades().get(0).getNombre()+" "+p1.getHabilidades().get(0).usosRestantes());
                                System.out.println("3.- "+p1.getHabilidades().get(2).getNombre()+" "+p1.getHabilidades().get(2).usosRestantes());
                                System.out.println("-------------------------");
                                opcion2 = s.nextInt();
                                s.nextLine();

                                //Si la opcion es 0 o menor, o mayor que 3 pedimos que elija una opcion valida
                                if(opcion2 <= 0 || opcion2 > 3) {
                                    System.out.println("Elige una opción válida");
                                } else { //En caso contrario hacemos lo siguiente
                                    //Creamos un switch case de la opcion
                                    switch (opcion2) {
                                        //Caso 1 hacemos la habilidad daño cuerpo a cuerpo
                                        case 1:
                                            //Comprobamos si le quedan usos restantes
                                            if(p1.getHabilidades().get(1).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p1.getHabilidades().get(1).getNombre());
                                                continue;
                                            }
                                            p1.getHabilidades().get(1).usar(p1, p2);
                                            break;
                                        //Caso 2 hacemos la habilidad curacion cuerpo a cuerpo
                                        case 2:
                                            //Comprobamos si le quedan usos restantes
                                            if(p1.getHabilidades().get(0).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p1.getHabilidades().get(0).getNombre());
                                                continue;
                                            }
                                            p1.getHabilidades().get(0).usar(p1, p2);
                                            break;
                                        //Caso 3 hacemos la habilidad daño a distancia
                                        case 3:
                                            //Comprobamos si le quedan usos restantes
                                            if(p1.getHabilidades().get(2).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p1.getHabilidades().get(2).getNombre());
                                                continue;
                                            }
                                            p1.getHabilidades().get(2).usar(p1, p2);
                                            break;
                                    }
                                    elegir2 = true;
                                }

                            } while(!elegir2);

                    }
                    elegir = true;
                }

            } while(!elegir);

            //Despues del turno del jugador1 comprobamos si ha acabado el combate
            if (acabado()) {
                break;
            }
            //Mostramos el nombre, vida actual y vida maxima de cada jugador
            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p2.getNombre()+" SELECCIONA UNA OPCION");
            int opcion3;
            //Hacemos lo siguiente mientras la opcion no sea valida
            do {
                elegir = false;
                System.out.println("-------------------------");
                System.out.println("1.- Atacar");
                System.out.println("2.- Habilidad");
                System.out.println("-------------------------");
                opcion3 = s.nextInt();
                s.nextLine();

                //Si la opcion es 2 y el jugador2 no tiene usos de ninguna habilidad volvemos a mostrar el menu
                if(opcion3 == 2 && !p2.tieneUsos()) {
                    System.out.println("No quedan más usos de ninguna habilidad");
                    continue;
                }
                //Si la opcion es 0 o menor, o mayor a 2 mostramos mensaje que elija una opcion valida
                if(opcion3 <= 0 || opcion3 > 2) {
                    System.out.println("Elige una opción válida");
                } else { //En caso contrario hacemos lo siguiente
                    //Creamos un switch case de la opcion
                    switch (opcion3) {
                        //Caso 1 usamos el ataque
                        case 1:
                            p2.getHabilidades().get(3).usar(p2, p1);
                            break;
                        //Caso 2 pedimos que elija la habilidad
                        case 2:
                            System.out.println("-------------------------");
                            System.out.println("ELIGE LA HABILIDAD");
                            //Llamo a un boolean y a un int para la eleccion
                            boolean elegir2;
                            int opcion2;
                            //Hacemos lo siguiente mientras la opcion no sea valida
                            do {
                                elegir2 = false;
                                //Mostramos la lista de habilidades con su nombre y usos restantes
                                System.out.println("-------------------------");
                                System.out.println("1.- "+p2.getHabilidades().get(1).getNombre()+" "+p2.getHabilidades().get(1).usosRestantes());
                                System.out.println("2.- "+p2.getHabilidades().get(0).getNombre()+" "+p2.getHabilidades().get(0).usosRestantes());
                                System.out.println("3.- "+p2.getHabilidades().get(2).getNombre()+" "+p2.getHabilidades().get(2).usosRestantes());
                                System.out.println("-------------------------");
                                opcion2 = s.nextInt();
                                s.nextLine();

                                //Si la opcion es 0 o menor, o mayor que 3 mostramos mensaje que elija una opcion valida
                                if(opcion2 <= 0 || opcion2 > 3) {
                                    System.out.println("Elige una opción válida");
                                } else { //En caso contrario hacemos lo siguiente
                                    //Creamos un switch case de la opcion
                                    switch (opcion2) {
                                        //Caso 1 usa la habilidad daño cuerpo a cuerpo
                                        case 1:
                                            //Comprobamos si le quedan usos
                                            if(p2.getHabilidades().get(1).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(1).getNombre());
                                                continue;
                                            }
                                            p2.getHabilidades().get(1).usar(p2, p1);
                                            break;
                                        //Caso 2 usa la habilidad curacion cuerpo a cuerop
                                        case 2:
                                            //Comprobamos si le quedan usos
                                            if(p2.getHabilidades().get(0).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(0).getNombre());
                                                continue;
                                            }
                                            p2.getHabilidades().get(0).usar(p2, p1);
                                            break;
                                        //Caso 3 usa la habilidad daño a distancia
                                        case 3:
                                            //Comprobamos si le quedan usos
                                            if(p2.getHabilidades().get(2).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(2).getNombre());
                                                continue;
                                            }
                                            p2.getHabilidades().get(2).usar(p2, p1);
                                            break;
                                    }
                                    elegir2 = true;
                                }

                            } while(!elegir2);
                    }
                    elegir = true;
                }

            } while(!elegir);

            //Despues del turno del jugador2 comprobamos si ha acabado
            if (acabado()) {
                break;
            }

            //Si no se acaba en ningun turno de los 2, se vuelve a hacer el bucle
        } while (!acabado());

        //Una vez termina el bucle buscamos quien es el que ha ganado
        //Si la vida del personaje1 es 0 o menor
        if(p1.getVidaBase() <= 0) {
            //Mostramos mensaje que el jugador2 ha ganado
            System.out.println(p2.getNombre()+" ha ganado el combate");
            System.out.println("-------------------------");
        } else {
            //En caso contrario muestra el mensaje que el jugador1 ha ganado
            System.out.println(p1.getNombre()+" ha ganado el combate");
            System.out.println("-------------------------");
        }

    }
}
