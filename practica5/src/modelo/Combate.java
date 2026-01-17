package modelo;

import habilidades.Ataque;
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
        p1.reinicio();
        p2.reinicio();

        Scanner s = new Scanner(System.in);
        this.personaje1 = p1;
        this.personaje2 = p2;
        System.out.println("INICIA " + personaje1.getNombre());
        do{
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p1.getNombre()+" SELECCIONA UNA OPCION");
            boolean elegir;
            int opcion;
            do {
                elegir = false;
                System.out.println("-------------------------");
                System.out.println("1.- Atacar");
                System.out.println("2.- Habilidad");
                System.out.println("-------------------------");
                opcion = s.nextInt();
                s.nextLine();

                if(opcion == 2 && !p1.tieneUsos()) {
                    System.out.println("No quedan más usos de ninguna habilidad");
                    continue;
                }
                if(opcion <= 0 || opcion > 2) {
                    System.out.println("Elige una opción válida");
                } else {
                    switch (opcion) {
                        case 1:
                            p1.getHabilidades().get(3).usar(p1, p2);
                            break;
                        case 2:
                            System.out.println("-------------------------");
                            System.out.println("ELIGE LA HABILIDAD");
                            boolean elegir2;
                            int opcion2;
                            do {
                                elegir2 = false;

                                System.out.println("-------------------------");
                                System.out.println("1.- "+p1.getHabilidades().get(1).getNombre()+" "+p1.getHabilidades().get(1).usosRestantes());
                                System.out.println("2.- "+p1.getHabilidades().get(0).getNombre()+" "+p1.getHabilidades().get(0).usosRestantes());
                                System.out.println("3.- "+p1.getHabilidades().get(2).getNombre()+" "+p1.getHabilidades().get(2).usosRestantes());
                                System.out.println("-------------------------");
                                opcion2 = s.nextInt();
                                s.nextLine();

                                if(opcion2 <= 0 || opcion2 > 3) {
                                    System.out.println("Elige una opción válida");
                                } else {
                                    switch (opcion2) {
                                        case 1:
                                            if(p2.getHabilidades().get(1).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(1).getNombre());
                                                continue;
                                            }
                                            p1.getHabilidades().get(1).usar(p1, p2);
                                            break;
                                        case 2:
                                            if(p2.getHabilidades().get(0).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(0).getNombre());
                                                continue;
                                            }
                                            p1.getHabilidades().get(0).usar(p1, p2);
                                            break;
                                        case 3:
                                            if(p2.getHabilidades().get(2).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(2).getNombre());
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


            if (acabado()) {
                break;
            }

            System.out.println(p2.getNombre()+": "+p2.getVidaBase()+"/"+p2.vidaInicial()+" puntos de vida");
            System.out.println(p1.getNombre()+": "+p1.getVidaBase()+"/"+p1.vidaInicial()+" puntos de vida");
            System.out.println("-------------------------");
            System.out.println(p2.getNombre()+" SELECCIONA UNA OPCION");
            int opcion3;
            do {
                elegir = false;
                System.out.println("-------------------------");
                System.out.println("1.- Atacar");
                System.out.println("2.- Habilidad");
                System.out.println("-------------------------");
                opcion3 = s.nextInt();
                s.nextLine();

                if(opcion3 == 2 && !p2.tieneUsos()) {
                    System.out.println("No quedan más usos de ninguna habilidad");
                    continue;
                }
                if(opcion3 <= 0 || opcion3 > 2) {
                    System.out.println("Elige una opción válida");
                } else {
                    switch (opcion3) {
                        case 1:
                            p2.getHabilidades().get(3).usar(p2, p1);
                            break;
                        case 2:
                            System.out.println("-------------------------");
                            System.out.println("ELIGE LA HABILIDAD");
                            boolean elegir2;
                            int opcion2;
                            do {
                                elegir2 = false;
                                System.out.println("-------------------------");
                                System.out.println("1.- "+p2.getHabilidades().get(1).getNombre()+" "+p2.getHabilidades().get(1).usosRestantes());
                                System.out.println("2.- "+p2.getHabilidades().get(0).getNombre()+" "+p2.getHabilidades().get(0).usosRestantes());
                                System.out.println("3.- "+p2.getHabilidades().get(2).getNombre()+" "+p2.getHabilidades().get(2).usosRestantes());
                                System.out.println("-------------------------");
                                opcion2 = s.nextInt();
                                s.nextLine();

                                if(opcion2 <= 0 || opcion2 > 3) {
                                    System.out.println("Elige una opción válida");
                                } else {
                                    switch (opcion2) {
                                        case 1:
                                            if(p2.getHabilidades().get(1).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(1).getNombre());
                                                continue;
                                            }
                                            p2.getHabilidades().get(1).usar(p2, p1);
                                            break;
                                        case 2:
                                            if(p2.getHabilidades().get(0).usosRestantes() <= 0) {
                                                System.out.println("No quedan más usos de "+p2.getHabilidades().get(0).getNombre());
                                                continue;
                                            }
                                            p2.getHabilidades().get(0).usar(p2, p1);
                                            break;
                                        case 3:
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
