package rpg.logic;

import rpg.model.Habilidades;
import rpg.model.Items;
import rpg.model.Personajes;
import rpg.utils.LoggerCustom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MotorCombate {
    private Scanner s = new Scanner(System.in);
    private Connection connection;

    public MotorCombate() {
        try {
            String url = "jdbc:postgresql://localhost:5432/XRPG";
            String user = "xrpg_user";
            String pass = "xrpg_password";

            connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            System.out.println("Error en la conexión de la base de datos");
            LoggerCustom.logError("Error en la conexión de la base de datos");
            e.printStackTrace();
        }
    }

    public void combate(Personajes jugador1, Personajes jugador2) {
        //Guardo los valores de vida de los personajes
        int vidaAntes1 = jugador1.getVida_actual();
        int vidaAntes2 = jugador2.getVida_actual();

        //Calculo el ataqueTotal y defensaTotal de cada personaje
        int ataqueTotal1 = jugador1.getRaza().getBonificador_fuerza();
        int defensaTotal1 = 0;

        //Recorro el HashMap del inventario de cada jugador y voy sumando el ataque y la defensa de los objetos
        for (Map.Entry<Items, Integer> entrada : jugador1.getInventario().entrySet()) {
            Items item = entrada.getKey();
            int cantidad = entrada.getValue();

            ataqueTotal1 += (item.getBonificador_ataque() * cantidad);
            defensaTotal1 += (item.getBonificador_defensa() * cantidad);
        }

        int ataqueTotal2 = jugador2.getRaza().getBonificador_fuerza();
        int defensaTotal2 = 0;

        for (Map.Entry<Items, Integer> entrada : jugador2.getInventario().entrySet()) {
            Items item = entrada.getKey();
            int cantidad = entrada.getValue();

            ataqueTotal2 += (item.getBonificador_ataque() * cantidad);
            defensaTotal2 += (item.getBonificador_defensa() * cantidad);
        }

        //Creo el HashMap de usosRestantes de cada personaje
        HashMap<Habilidades, Integer> usosRestantes1 = new HashMap<>();

        //Recorro el HashMap de las habilidades de los personajes y si las tiene activas la añadimos a las habilidades usables
        for (Map.Entry<Habilidades, Boolean> entrada : jugador1.getHabilidades().entrySet()) {
            if (entrada.getValue() == true) {
                Habilidades hab = entrada.getKey();
                usosRestantes1.put(hab, hab.getUsos_maximos());
            }
        }

        HashMap<Habilidades, Integer> usosRestantes2 = new HashMap<>();

        for (Map.Entry<Habilidades, Boolean> entrada : jugador2.getHabilidades().entrySet()) {
            if (entrada.getValue() == true) {
                Habilidades hab = entrada.getKey();
                usosRestantes2.put(hab, hab.getUsos_maximos());
            }
        }

        System.out.println("Empieza el combate");
        System.out.println(jugador1.getNombre()+" - Vida: "+jugador1.getVida_actual());
        System.out.println(jugador2.getNombre()+" - Vida: "+jugador2.getVida_actual());
        boolean salir = false;
        do {
            //Primero va el turno del jugador 1
            System.out.println("Turno de "+jugador1.getNombre()+" - Vida: "+jugador1.getVida_actual());
            boolean elegir1 = false;

            do {
                System.out.println("1.- Ataque normal");
                System.out.println("2.- Usar habilidad");
                int opcion1 = s.nextInt();

                switch (opcion1) {
                    case 1:
                        int dañoRealizadoA = ataqueTotal1 - (defensaTotal2 / 2);
                        jugador2.setVida_actual(jugador2.getVida_actual()- dañoRealizadoA);

                        System.out.println(jugador1.getNombre()+" ha hecho "+dañoRealizadoA+" puntos de daño");
                        if(jugador2.getVida_actual() <= 0) {
                            jugador2.setVida_actual(0);
                        }
                        System.out.println("Vida actual de "+jugador2.getNombre()+": "+jugador2.getVida_actual());
                        elegir1 = true;
                        break;
                    case 2:
                        System.out.println("Habilidades:");
                        for (Map.Entry<Habilidades, Integer> entrada : usosRestantes1.entrySet()) {
                            Habilidades hab = entrada.getKey();
                            int usos = entrada.getValue();
                            System.out.println("ID: "+hab.getIdHabilidades()+" - "+hab.getNombre()+" - Usos restantes: " + usos);
                        }

                        System.out.println("ID de la habilidad a usar:");
                        int idElegido = s.nextInt();

                        Habilidades habilidadElegida = null;
                        for (Habilidades h : usosRestantes1.keySet()) {
                            if (h.getIdHabilidades() == idElegido) {
                                habilidadElegida = h;
                                break;
                            }
                        }

                        if (habilidadElegida == null) {
                            System.out.println("Esa id no existe");
                        } else {
                            int usosActuales = usosRestantes1.get(habilidadElegida);
                            if(usosActuales <= 0) {
                                //Si no quedan usos de esa habilidad se hace un ataque normal
                                System.out.println("No quedan usos para "+habilidadElegida.getNombre()+" se va a atacar normal");
                                int dañoRealizadoB = ataqueTotal1 - (defensaTotal2 / 2);
                                jugador2.setVida_actual(jugador2.getVida_actual()- dañoRealizadoB);

                                System.out.println(jugador1.getNombre()+" ha hecho "+dañoRealizadoB+" puntos de daño");
                                if(jugador2.getVida_actual() <= 0) {
                                    jugador2.setVida_actual(0);
                                }
                                System.out.println("Vida actual de "+jugador2.getNombre()+": "+jugador2.getVida_actual());
                                elegir1 = true;
                                break;
                            } else {
                                usosRestantes1.put(habilidadElegida, usosActuales - 1);

                                int dañoHabilidad = habilidadElegida.getDaño_base();

                                int dañoRealizadoH = dañoHabilidad - (defensaTotal2 / 2);

                                jugador2.setVida_actual(jugador2.getVida_actual()- dañoRealizadoH);

                                System.out.println(jugador1.getNombre()+" usa "+habilidadElegida.getNombre()+" y hace "+ dañoRealizadoH +" puntos de daño");
                                if(jugador2.getVida_actual() <= 0) {
                                    jugador2.setVida_actual(0);
                                }
                                System.out.println("Vida actual de "+jugador2.getNombre()+": "+jugador2.getVida_actual());

                                elegir1 = true;
                                break;
                            }
                        }
                }

            } while (!elegir1);

            //Compruebo si ha muerto el jugador2
            if(jugador2.getVida_actual() <= 0) {
                salir = true;
                break;
            }

            //Turno del jugador 2
            System.out.println("Turno de "+jugador2.getNombre()+" - Vida: "+jugador2.getVida_actual());
            boolean elegir2 = false;

            do {
                System.out.println("1.- Ataque normal");
                System.out.println("2.- Usar habilidad");
                int opcion2 = s.nextInt();

                switch (opcion2) {
                    case 1:
                        int dañoRealizadoA = ataqueTotal2 - (defensaTotal1 / 2);

                        jugador1.setVida_actual(jugador1.getVida_actual()- dañoRealizadoA);

                        System.out.println(jugador2.getNombre()+" ha hecho "+dañoRealizadoA+" puntos de daño");
                        if(jugador1.getVida_actual() <= 0) {
                            jugador1.setVida_actual(0);
                        }
                        System.out.println("Vida actual de "+jugador1.getNombre()+": "+jugador1.getVida_actual());
                        elegir2 = true;
                        break;
                    case 2:
                        System.out.println("Habilidades:");
                        for (Map.Entry<Habilidades, Integer> entrada : usosRestantes2.entrySet()) {
                            Habilidades hab = entrada.getKey();
                            int usos = entrada.getValue();
                            System.out.println("ID: "+hab.getIdHabilidades()+" - "+hab.getNombre()+" - Usos restantes: " + usos);
                        }

                        System.out.println("ID de la habilidad a usar:");
                        int idElegido = s.nextInt();

                        Habilidades habilidadElegida = null;
                        for (Habilidades h : usosRestantes2.keySet()) {
                            if (h.getIdHabilidades() == idElegido) {
                                habilidadElegida = h;
                                break;
                            }
                        }

                        if (habilidadElegida == null) {
                            System.out.println("Esa id no existe");
                        } else {
                            //Si no quedan usos de esa habilidad se hace un ataque normal
                            int usosActuales = usosRestantes2.get(habilidadElegida);
                            if(usosActuales <= 0) {
                                System.out.println("No quedan usos para "+habilidadElegida.getNombre()+" se va a atacar normal");
                                int dañoRealizadoB = ataqueTotal2 - (defensaTotal1 / 2);

                                jugador1.setVida_actual(jugador1.getVida_actual()- dañoRealizadoB);

                                System.out.println(jugador2.getNombre()+" ha hecho "+ dañoRealizadoB +" puntos de daño");
                                if(jugador1.getVida_actual() <= 0) {
                                    jugador1.setVida_actual(0);
                                }

                                System.out.println("Vida actual de "+jugador1.getNombre()+": "+jugador1.getVida_actual());

                                elegir2 = true;
                                break;
                            } else {
                                usosRestantes2.put(habilidadElegida, usosActuales - 1);

                                int dañoHabilidad = habilidadElegida.getDaño_base();

                                int dañoRealizadoH = dañoHabilidad - (defensaTotal1 / 2);

                                jugador1.setVida_actual(jugador1.getVida_actual()- dañoRealizadoH);

                                System.out.println(jugador2.getNombre()+" usa "+habilidadElegida.getNombre()+" y hace "+ dañoRealizadoH +" puntos de daño");
                                if(jugador1.getVida_actual() <= 0) {
                                    jugador1.setVida_actual(0);
                                }

                                System.out.println("Vida actual de "+jugador1.getNombre()+": "+jugador1.getVida_actual());

                                elegir2 = true;
                                break;
                            }
                        }
                }

                //Compruebo si ha muerto el jugador1
                if(jugador1.getVida_actual() <= 0) {
                    salir = true;
                    break;
                }
            } while (!elegir2);
        } while (!salir);

        System.out.println("Final del combate");

        //Al terminar el combate miro cual es el jugador que ha muerto
        if(jugador1.getVida_actual() == 0) {
            LoggerCustom.logInfo("El combate a terminado y ha ganado"+jugador2.getNombre());
            System.out.println("Ha ganado "+jugador2.getNombre()+" - Vida: "+jugador2.getVida_actual());
            int oroRobado = (int) (jugador1.getOro() * 0.2);

            System.out.println(jugador2.getNombre()+" recibe "+oroRobado+" monedas de oro por ganar");

            //Calculo el oro que tienen ahora cada personaje
            int oroAntesG = jugador2.getOro();
            int oroAntesP = jugador1.getOro();

            jugador2.setOro(oroAntesG+oroRobado);
            jugador1.setOro(oroAntesP-oroRobado);
            try {
                PreparedStatement psG = connection.prepareStatement("UPDATE PERSONAJES SET oro = ? WHERE id = ?");

                psG.setInt(1, oroAntesG +oroRobado);
                psG.setInt(2, jugador2.getIdPersonaje());

                psG.executeUpdate();

                PreparedStatement psP = connection.prepareStatement("UPDATE PERSONAJES SET oro = ? WHERE id = ?");

                psP.setInt(1, oroAntesP-oroRobado);
                psP.setInt(2, jugador1.getIdPersonaje());

                psP.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            LoggerCustom.logInfo("El combate a terminado y ha ganado"+jugador1.getNombre());
            System.out.println("Ha ganado "+jugador1.getNombre()+" - Vida: "+jugador1.getVida_actual());
            int oroRobado = (int) (jugador2.getOro() * 0.2);

            System.out.println(jugador1.getNombre()+" recibe "+oroRobado+" monedas de oro por ganar");

            //Calculo el oro que tienen ahora cada personaje
            int oroAntesG = jugador1.getOro();
            int oroAntesP = jugador2.getOro();

            jugador1.setOro(oroAntesG+oroRobado);
            jugador2.setOro(oroAntesP-oroRobado);
            try {
                PreparedStatement psG = connection.prepareStatement("UPDATE PERSONAJES SET oro = ? WHERE id = ?");

                psG.setInt(1, oroAntesG +oroRobado);
                psG.setInt(2, jugador1.getIdPersonaje());

                psG.executeUpdate();

                PreparedStatement psP = connection.prepareStatement("UPDATE PERSONAJES SET oro = ? WHERE id = ?");

                psP.setInt(1, oroAntesP-oroRobado);
                psP.setInt(2, jugador2.getIdPersonaje());

                psP.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //Reinicio la vida de los personajes
        jugador1.setVida_actual(vidaAntes1);
        jugador2.setVida_actual(vidaAntes2);

    }
}
