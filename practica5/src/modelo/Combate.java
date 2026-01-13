package modelo;

import habilidades.Habilidades;

import java.util.Scanner;

public class Combate {
    private Personaje personaje1;
    private Personaje personaje2;

    public Combate() {

    }
    public boolean acabado() {
        if(this.personaje1.getVidaBase() <= 0 || this.personaje2.getVidaBase() <= 0) {
            return true;
        } else {
            return false;
        }
    }
    public void combate(Personaje p1, Personaje p2) {
        Scanner s = new Scanner(System.in);
        this.personaje1 = p1;
        this.personaje2 = p2;
        boolean acabar = false;
        System.out.println("INICIA " + personaje1.getNombre());
        do{
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p1.getNombre()+" SELECCIONA UNA OPCION");
            System.out.println("-------------------------");
            System.out.println("1.- Atacar");
            System.out.println("2.- Habilidad");
            System.out.println("-------------------------");
            int opcion = s.nextInt();

            switch (opcion) {
                case 1:
                    p1.getHabilidades().get(3).usar(p1, p2);
                    break;
                case 2:
                    System.out.println("-------------------------");
                    System.out.println("ELIGE LA HABILIDAD");
                    System.out.println("-------------------------");
                    System.out.println("1.- "+p1.getHabilidades().get(1).getNombre()+" "+p1.getHabilidades().get(1).usosRestantes());
                    System.out.println("2.- "+p1.getHabilidades().get(0).getNombre()+" "+p1.getHabilidades().get(0).usosRestantes());
                    System.out.println("3.- "+p1.getHabilidades().get(2).getNombre()+" "+p1.getHabilidades().get(2).usosRestantes());
                    System.out.println("-------------------------");
                    int opcion2 = s.nextInt();

                    switch (opcion2) {
                        case 1:
                            p1.getHabilidades().get(1).usar(p1, p2);
                            break;
                        case 2:
                            p1.getHabilidades().get(0).usar(p1, p2);
                            break;
                        case 3:
                            p1.getHabilidades().get(2).usar(p1, p2);
                            break;
                        default:
                            continue;
                    }
            }

            if (acabado()) {
                break;
            }

            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p2.getNombre()+" SELECCIONA UNA OPCION");
            System.out.println("-------------------------");
            System.out.println("1.- Atacar");
            System.out.println("2.- Habilidad");
            System.out.println("-------------------------");
            int opcion3 = s.nextInt();

            switch (opcion3) {
                case 1:
                    p2.getHabilidades().get(3).usar(p2, p1);
                    break;
                case 2:
                    System.out.println("-------------------------");
                    System.out.println("ELIGE LA HABILIDAD");
                    System.out.println("-------------------------");
                    System.out.println("1.- "+p2.getHabilidades().get(1).getNombre()+" "+p2.getHabilidades().get(1).usosRestantes());
                    System.out.println("2.- "+p2.getHabilidades().get(0).getNombre()+" "+p2.getHabilidades().get(0).usosRestantes());
                    System.out.println("3.- "+p2.getHabilidades().get(2).getNombre()+" "+p2.getHabilidades().get(2).usosRestantes());
                    System.out.println("-------------------------");
                    int opcion2 = s.nextInt();

                    switch (opcion2) {
                        case 1:
                            p2.getHabilidades().get(1).usar(p2, p1);
                            break;
                        case 2:
                            p2.getHabilidades().get(0).usar(p2, p1);
                            break;
                        case 3:
                            p2.getHabilidades().get(2).usar(p2, p1);
                            break;
                        default:
                            continue;
                    }
            }
            if (acabado()) {
                break;
            }

        } while (!acabado());

        if(p1.getVidaBase() <= 0) {
            System.out.println(p2.getNombre()+" ha ganado el combate");
            System.out.println("-------------------------");
        } else {
            System.out.println(p1.getNombre()+" ha ganado el combate");
            System.out.println("-------------------------");
        }

    }
}
//Crear lista personajes