import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ejercicio15 {

    //Creo el metodo procesarVenta al que se le tiene que pasar el nombre del item, el hashmap de las pujas y el hashmap del saldo de los jugadores
    public static void procesarVenta(String item, HashMap<String, PriorityQueue<Puja>> pujaItems, HashMap<String, Double> saldoJugadores) {
        //Si en el hashmap de las pujas esta el item hacemos lo siguiente
        if(pujaItems.containsKey(item)) {
            //Mostramos la lista de participantes
            System.out.println("Lista de pujantes: "+pujaItems.get(item));
            System.out.println("-------------");

            //Hacemos lo siguiente mientras la lista de pujas de ese item no este vacia
            do {
                //Obtenemos el pujante mas alto, su nombre y cantidad
                Puja primero = pujaItems.get(item).poll(); //Lo guardamos y lo borramos de la lista de pujaItems
                String primeroNombre = primero.getJugador();
                double primeroCantidad = primero.getCantidad();

                //Hacemos un for each de los pujantes y sus saldos
                for (String m: saldoJugadores.keySet()) {
                    //Si es igual al pujante as alto
                    if(m.equals(primeroNombre)) {
                        //Comprobamos si tiene dinero suficiente para comprarlo
                        if(saldoJugadores.get(m) >= primeroCantidad) {
                            //Guardamos el saldo nuevo que tendrá
                            double nuevoSaldo = saldoJugadores.get(m) - primeroCantidad;
                            //Y le asociamos el nuevo saldo
                            saldoJugadores.put(m, nuevoSaldo);

                            //Mostramos el mensaje de vendido y el dinero restante
                            System.out.println("Vendido "+item+" a "+primeroNombre+" por "+primeroCantidad);
                            System.out.println("Balance restante: "+nuevoSaldo);
                            System.out.println("-------------");
                            //Mostramos la lista de los pujantes que quedaban
                            System.out.println("Lista de las pujas que quedaban: "+ pujaItems.get(item));
                            //Returneamos para acabar el bucle
                            return;

                        } else { //Si el jugador no tiene dinero suficiente mostramos el mensaje
                            System.out.println(primeroNombre+" no tiene suficiente dinero, puja "+primeroCantidad+" y tiene "+saldoJugadores.get(m));
                            System.out.println("-------------");
                        }
                    }
                    //Y pasamos al siguiente jugador en caso de que no tenga el dinero suficiente
                }
            } while (!pujaItems.get(item).isEmpty());
            System.out.println("No hay pujantes que puedan comprarlo");

        } else { //Si en el hashmap no esta el item pasado mostramos el mensaje
            System.out.println("No hay ese item");
        }
    }

    public static void main(String[] args) {
        //Creamos un hashmap de string y priorityQueue tipo Puja para guardar el jugador que puja cada cantidad
        HashMap<String, PriorityQueue<Puja>> pujaItems = new HashMap<>();
        //Creamos la priorityQueue del item y le ponemos que lo guarde de mayor a menor cantidad pujada
        PriorityQueue<Puja> pujaGuantesdeJesus = new PriorityQueue<>(Comparator.comparing(Puja::getCantidad).reversed());
        pujaGuantesdeJesus.add(new Puja(400.0,"Mario"));
        pujaGuantesdeJesus.add(new Puja(200.0,"Oscar"));
        pujaGuantesdeJesus.add(new Puja(500.0,"Josemi"));


        pujaItems.put("Guantes de Jesus", pujaGuantesdeJesus);

        //Creamos el hashmap tipo string double del saldo de los jugadores
        HashMap<String, Double> saldoJugadores = new HashMap<>();
        saldoJugadores.put("Mario", 400.0);
        saldoJugadores.put("Oscar", 300.0);
        saldoJugadores.put("Josemi", 400.0);

        //Llamamos al metodo
        procesarVenta("Guantes de Jesus", pujaItems, saldoJugadores);

    }
}
