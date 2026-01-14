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
        System.out.println("INICIA " + personaje1.getNombre());
        do{
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p1.getNombre()+" SELECCIONA UNA OPCION");
            int opcion;
            do {
                System.out.println("-------------------------");
                System.out.println("1.- Atacar");
                System.out.println("2.- Habilidad");
                System.out.println("-------------------------");
                opcion = s.nextInt();
                if(opcion < 1 || opcion > 2) {
                    System.out.println("Elige una opción válida");
                }
                switch (opcion) {
                    case 1:
                        p1.getHabilidades().get(3).usar(p1, p2);
                        break;
                    case 2:
                        System.out.println("-------------------------");
                        System.out.println("ELIGE LA HABILIDAD");
                        int opcion2;
                        do {
                            System.out.println("-------------------------");
                            System.out.println("1.- "+p1.getHabilidades().get(1).getNombre()+" "+p1.getHabilidades().get(1).usosRestantes());
                            System.out.println("2.- "+p1.getHabilidades().get(0).getNombre()+" "+p1.getHabilidades().get(0).usosRestantes());
                            System.out.println("3.- "+p1.getHabilidades().get(2).getNombre()+" "+p1.getHabilidades().get(2).usosRestantes());
                            System.out.println("-------------------------");
                            opcion2 = s.nextInt();
                            if(opcion2 < 1 || opcion2 > 3) {
                                System.out.println("Elige una opción válida");
                            }
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

                            }
                        } while (opcion2 < 1 || opcion2 > 3);

                }
            } while (opcion < 1 || opcion > 2);

            if (acabado()) {
                break;
            }

            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p2.getNombre()+" SELECCIONA UNA OPCION");
            int opcion2;
            do {
                System.out.println("-------------------------");
                System.out.println("1.- Atacar");
                System.out.println("2.- Habilidad");
                System.out.println("-------------------------");
                opcion2 = s.nextInt();
                if(opcion2 < 1 || opcion2 > 2) {
                    System.out.println("Elige una opción válida");
                }
                switch (opcion2) {
                    case 1:
                        p2.getHabilidades().get(3).usar(p2, p1);
                        break;
                    case 2:
                        System.out.println("-------------------------");
                        System.out.println("ELIGE LA HABILIDAD");
                        int opcion3;
                        do {
                            System.out.println("-------------------------");
                            System.out.println("1.- "+p2.getHabilidades().get(1).getNombre()+" "+p2.getHabilidades().get(1).usosRestantes());
                            System.out.println("2.- "+p2.getHabilidades().get(0).getNombre()+" "+p2.getHabilidades().get(0).usosRestantes());
                            System.out.println("3.- "+p2.getHabilidades().get(2).getNombre()+" "+p2.getHabilidades().get(2).usosRestantes());
                            System.out.println("-------------------------");
                            opcion3 = s.nextInt();
                            if(opcion3 < 1 || opcion3 > 3) {
                                System.out.println("Elige una opción válida");
                            }
                            switch (opcion3) {
                                case 1:
                                    p2.getHabilidades().get(1).usar(p2, p1);
                                    break;
                                case 2:
                                    p2.getHabilidades().get(0).usar(p2, p1);
                                    break;
                                case 3:
                                    p2.getHabilidades().get(2).usar(p2, p1);
                                    break;

                            }
                        } while (opcion3 < 1 || opcion3 > 3);

                }
            } while(opcion2 < 1 || opcion2 > 2);

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
