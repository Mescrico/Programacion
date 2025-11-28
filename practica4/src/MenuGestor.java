import java.util.ArrayList;
import java.util.Scanner;

//Creamos la clase MenuGestor
public class MenuGestor {
    //Creamos los arraylist que va a tener la clase menugestor
    private ArrayList<Hospital> hospitales = new ArrayList<>();
    private ArrayList<Direccion> direcciones = new ArrayList<>();
    private ArrayList<Areas> areas = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    //Creamos ya algunos objetos en las clases para que esten precargadas automaticamente al runnear el programa
    Direccion d1 = new Direccion("Es", 5, 11630, "Arcos", "Cádiz");
    Direccion d2 = new Direccion("Es", 5, 11630, "Arcos", "Cádiz");
    Hospital h1 = new Hospital("1", "1", d1);
    Areas a1 = new Areas("1", "1", 2, h1);
    Medico m1 = new Medico("1", "Mario", 18, "Hombre", 1000, 2000, a1, d2);
    Contrato c1 = new Contrato(m1.getAñosInicio(), m1, h1);

    //Creamos la funcion de buscar medico
    public Medico buscarMedico() {
        //Pedirá que se introduzca el DNI del medico a buscar
        System.out.println("Introduce el DNI");
        String dni = s.nextLine();

        //Creamos un objeto medico
        Medico medico;
        //Creamos el bucle que recorrera todos los medicos existentes
        for (int i = 0; i < medicos.size(); i++) {
            //Si encuentra algun medico que tenga el mismo dni que el introducido
            if(medicos.get(i).getDni().equals(dni)) {
                //Asignará al objeto medico creado anteriormente los valores del medico de esa posición
                medico = medicos.get(i);
                //Y devolverá el objeto medico
                return medico;
            }
        }
        //Si no lo encuentra devolverá null
        return null;
    }

    //Creamos la funcion de buscar hospital
    public Hospital buscarHospital() {
        //Pedirá que se le introduzca el nombre del hospital a buscar
        System.out.println("Introduce el nombre del hospital");
        String nombre = s.nextLine();

        //Creamos un objeto hospital
        Hospital hospital;
        //Creamos el bucle que recorrera todos los hospitales existentes
        for (int i = 0; i < hospitales.size(); i++) {
            //Si encuentra algun hospital que tenga el mismo nombre que el introducido
            if(hospitales.get(i).getNombre().equals(nombre)) {
                //Asignará al objeto hospital creado anteriormente los valores del hospital de esa posición
                hospital = hospitales.get(i);
                //Y devolverá el objetohospital
                return hospital;
            }
        }
        //Si no lo encuentra devolverá null
        return null;
    }

    //Creamos la funcion de buscar area que se le tiene que introducir el hospital al que buscar las areas
    public Areas buscarAreas(Hospital hospitalpuesto) {
        //Pedirá que se le introduzca el identificador del área a buscar del hospital introducido
        System.out.println("Introduce el Identificador del área del hospital "+hospitalpuesto.getNombre());
        String ident = s.nextLine();

        //Creamos el objeto area
        Areas area;
        //Creamos el bucle que recorrera en todas las areas del hospital introducido
        for (int i = 0; i < hospitalpuesto.getAreas().size(); i++) {
            //Si encuentro algun area dentro del hospital introducido que tenga el mismo identificador que el introducido
            if(hospitalpuesto.getAreas().get(i).getIdentificador().equals(ident)) {
                //Asignará al objeto area creado anteriormente los valores del area de esa posición
                area = hospitalpuesto.getAreas().get(i);
                //Y devolverá el objeto area
                return area;
            }
        }
        //Si no lo encuentra devolverá null
        return null;
    }

    //Creamos la funcion de crear hospital
    public void crearHospital() {
        //Pedimos que introduzca el nombre del hospital
        System.out.println("Di el nombre del hospital");
        String nombre = s.nextLine();

        //Creamos las variables de existe y del cif
        boolean existe;
        String cif;

        //Hacemos lo siguiente mientras exista
        do {
            //Reiniciamos existe como falso en cada iteracion
            existe = false;
            //Pedimos el cif que se asignara al hospital
            System.out.println("Di el CIF del hospital");
            cif = s.nextLine();

            //Creamos el bucle que recorrera todos los hospitales
            for (int i = 0; i < hospitales.size(); i++) {
                //Si en algun hospital encuentra alguno que tenga el mismo cif que el introducido
                if (hospitales.get(i).getCif().equals(cif)) {
                    //Marcamos existe como true
                    existe = true;
                    //Y mostramos el mensaje que ese cif ya existe y que ponga otro
                    System.out.println("El CIF ya existe, pon otro");
                }
            }
        } while (existe);

        //Pedimos la dirección del hospital
        System.out.println("Ahora di la dirección del hospital:");
        System.out.println("Di la calle");
        String calle = s.nextLine();
        System.out.println("Di el numero");
        int numero = s.nextInt();
        //Después de un nextInt o nextDouble hay que poner un nextLine para que limpiemos la entrada, ya que pulsamos el enter y se queda como espacio asignado
        s.nextLine();
        System.out.println("Di el código postal");
        int codigoPostal = s.nextInt();
        s.nextLine();
        System.out.println("Di la localidad");
        String localidad = s.nextLine();
        System.out.println("Di la provincia");
        String provincia = s.nextLine();

        //Creamos los objetos de nueva direccion y hospital y le asignamos los valores introducidos
        Direccion nuevaDireccion = new Direccion(calle, numero, codigoPostal, localidad, provincia);
        Hospital nuevoHospital = new Hospital(nombre, cif, nuevaDireccion);
        //A la lista de direcciones le añadimos la nueva direccion creada
        direcciones.add(nuevaDireccion);
        //A la lista de hospitales le añadimos el nuevo hospital creado
        hospitales.add(nuevoHospital);

        //Printeamos el mensaje de que el hospital ya se ha creado
        System.out.println("Hospital creado: " + nuevoHospital.getNombre() + " CIF: "+nuevoHospital.getCif());
    }

    //Creamos la funcion de crear Area
    public void crearArea() {
        //Si no hay hospitales devolvemos el mensaje de que primero se tiene que crear un hospital y ahí termina
        if(hospitales.isEmpty()) {
            System.out.println("No hay hospitales, primero crea uno");
        } else {
            //En caso contrario pedimos que asigne el nombre del area
            System.out.println("Di el nombre del area");
            String nombre = s.nextLine();

            //Creamos las variables de existe, de planta y de indentificador
            boolean existe;
            int planta;
            String identificador;

            //Hacemos lo siguiente mientras exista
            do {
                //Reiniciamos existe a falso en cada iteracion
                existe = false;
                //Pedimos que introduzca el identificador y la planta
                System.out.println("Di el identificador del área");
                identificador = s.nextLine();
                System.out.println("Di la planta");
                planta = s.nextInt();

                //Creamos un bucle que recorra todas las areas
                for (int i = 0; i < areas.size(); i++) {
                    //Si encontramos algun area que tenga el mismo identificador que el introducido
                    if (areas.get(i).getIdentificador().equals(identificador)) {
                        //Marcamos existe como true
                        existe = true;
                        //Printeamos el mensaje de que ya existe y que ponga otro
                        System.out.println("El Identificador ya existe, pon otro");
                    }
                }
            } while(existe);

            //Creamos las variables de opcion y de encontr
            int opcion;
            boolean encontr;

            //Hacemos lo siguiente mientras no se encuentre
            do {
                //Reiniciamos en cada iteracion encontr como falso
                encontr = false;
                //Pedimos que elija el hospital por el numero
                System.out.println("Di el hospital por el numero");

                //Creamos un bucle con el tamaño de los hospitales que va a servir para mostrar en una lista todos los hospitales y que el usuario elija
                for (int i = 0; i < hospitales.size(); i++) {
                    System.out.printf(i + ".- " + hospitales.get(i).getNombre() + " CIF: "+hospitales.get(i).getCif() +"%n");
                }

                opcion = s.nextInt();
                s.nextLine();

                //Si ha introducido un numero mayor o igual a la lista de hospitales o menor a 0
                if (opcion >= hospitales.size() || opcion < 0) {
                    //Printeamos que no hay hospital con ese numero
                    System.out.println("Ningún hospital tiene ese número");
                } else {
                    //En caso contrario marcamos encontr como true y ahi termina el do-while
                    encontr = true;
                }
            } while (!encontr);

            //Creamos el objeto seleccion y le asignamos los valores de la opcion elegida
            Hospital seleccion = hospitales.get(opcion);
            //Creamos un nuevo area y asignamos los valores con los introducidos anteriormente
            Areas nuevoArea = new Areas(nombre, identificador, planta, seleccion);
            //Agregamos a la lista de areas ese nuevo area
            areas.add(nuevoArea);

            System.out.println("Área creada: " + nuevoArea);
        }
    }

    //Creamos la funcion de crear medico
    public void crearMedico() {
        //Si no hay areas no va a haber medicos por lo que le printeamos que tiene primero que crear un area y ahi termina
        if(areas.isEmpty()) {
            System.out.println("No hay áreas, primero debes crear uno");
        } else {
            //En caso contrario pedimos los datos del medico
            System.out.println("Di el DNI del médico");
            String dni = s.nextLine();
            System.out.println("Di el nombre");
            String nombre = s.nextLine();
            System.out.println("Di la edad");
            int edad = s.nextInt();
            System.out.println("Di el sexo");
            String sexo = s.nextLine();
            s.nextLine();
            System.out.println("Di el sueldo bruto");
            int sueldoBruto = s.nextInt();
            System.out.println("Di el año de inicio");
            int añoInicio = s.nextInt();

            //Creamos las variables de opcion y encontr
            int opcion;
            boolean encontr;

            //Hacemos lo siguiente mientras no se encuentra
            do {
                //Reiniciamos la variable encontr a falso en cada iteracion
                encontr = false;

                //Pedimos que elija el hospital por el numero
                System.out.println("Di el área por el número");

                //Creamos el bucle que va a tener de tamaño areas, que sirve para mostrar en lista todas las areas existentes para que el usuario elija
                for (int i = 0; i < areas.size(); i++) {
                    System.out.printf(i + ".- " + areas.get(i).getNombre() + " Identificador: " + areas.get(i).getIdentificador() + " Hospital: "+ areas.get(i).getHospital().getNombre()+"%n");
                }

                opcion = s.nextInt();
                s.nextLine();

                //Si el numero introducido es mayor o igual que el tamaño de areas o es menor que 0 le printeamos que no hay ningun area con ese numero
                if (opcion >= areas.size() || opcion < 0) {
                    System.out.println("Ningún área tiene ese número");
                } else {
                    //En caso contrario marcamos encontr como true
                    encontr = true;
                }
            } while (!encontr);

            //Creamos el objeto seleccion que va a tener los valores de la opcion elegida
            Areas seleccion = areas.get(opcion);

            //Pedimos que asigne la direccion del medico
            System.out.println("Ahora di la dirección del médico:");
            System.out.println("Di la calle");
            String calle = s.nextLine();
            System.out.println("Di el numero");
            int numero = s.nextInt();
            s.nextLine();
            System.out.println("Di el código postal");
            int codigoPostal = s.nextInt();
            s.nextLine();
            System.out.println("Di la localidad");
            String localidad = s.nextLine();
            System.out.println("Di la provincia");
            String provincia = s.nextLine();

            //Creamos el objeto nueva direccion y le asignamos los datos de la direccion del medico introducidos anteriormente
            Direccion nuevaDireccion = new Direccion(calle, numero, codigoPostal, localidad, provincia);
            //Añadimos a la lista direcciones el objeto nueva direccion
            direcciones.add(nuevaDireccion);
            //Creamos el objeto nuevo medico y le asignamos los datos del medico introducidos anteriormente
            Medico nuevoMedico = new Medico(dni, nombre, edad, sexo, sueldoBruto, añoInicio, seleccion, nuevaDireccion);
            //Añadimos a la lista de medicos el objeto nuevo medico
            medicos.add(nuevoMedico);
            //Añadimos a la lista contratos el contrato generado por el objeto nuevo medico
            contratos.add(nuevoMedico.getContrato());
            System.out.println("Medico y Contrato creado:");
            System.out.println("Nombre: "+nuevoMedico.getNombre()+" DNI: "+nuevoMedico.getDni()+ " Hospital: "+nuevoMedico.getAreas().getHospital().getNombre());
        }
    }




    public void menu() {
        direcciones.add(d1);
        direcciones.add(d2);
        hospitales.add(h1);
        areas.add(a1);
        medicos.add(m1);
        contratos.add(c1);

        boolean terminar = false;
        do {
            System.out.println("1.- Crear Hospital");
            System.out.println("2.- Crear Área");
            System.out.println("3.- Crear Médico");
            System.out.println("4.- Modificar Médico");
            System.out.println("5.- Modificar Hospital");
            System.out.println("6.- Calcular Antigüedad");
            System.out.println("7.- Calcular Sueldo Neto");
            System.out.println("8.- Comprobar Edad");
            System.out.println("9.- Proporción de Médicos");
            System.out.println("10.- Capacidad de Área");
            System.out.println("11.- Comparar Áreas");
            System.out.println("12.- Contratos por Año");
            System.out.println("0.- Salir");
            System.out.println("-----------------------------");

            int opcion = s.nextInt();
            s.nextLine();

            switch (opcion) {
                case 1:
                    crearHospital();
                    break;
                case 2:
                    crearArea();
                    break;
                case 3:
                    crearMedico();
                    break;
                case 4:
                    if(medicos.isEmpty()) {
                        System.out.println("No hay médicos, primero crea uno");
                        break;
                    }
                    Medico medicoSeleccionado = buscarMedico();
                    if (medicoSeleccionado == null) {
                        System.out.println("No hay ningún médico con ese DNI");
                        break;
                    }
                    System.out.println("Que quieres cambiar");
                    System.out.println("1.- Sueldo Bruto");
                    System.out.println("2.- Dirección");
                    System.out.println("3.- Área de trabajo");
                    System.out.println("0.- Salir");
                    int seleccion = s.nextInt();
                    s.nextLine();
                    switch (seleccion) {
                        case 1:
                            System.out.println("Cantidad nueva:");
                            int cantidad = s.nextInt();
                            s.nextLine();
                            medicoSeleccionado.setSueldoBruto(cantidad);
                            System.out.println("Cantidad del médico "+medicoSeleccionado.getNombre()+" actualizada");
                            break;
                        case 2:
                            System.out.println("Dirección nueva:");
                            System.out.println("Calle:");
                            String calle = s.nextLine();
                            System.out.println("Número:");
                            int numero = s.nextInt();
                            System.out.println("Código postal:");
                            int cp = s.nextInt();
                            s.nextLine();
                            System.out.println("Localidad:");
                            String localidad = s.nextLine();
                            System.out.println("Provincia:");
                            String provincia = s.nextLine();

                            Direccion nuevaDireccion = new Direccion(calle, numero, cp, localidad, provincia);
                            medicoSeleccionado.setDireccion(nuevaDireccion);
                            System.out.println("Dirección del médico "+medicoSeleccionado.getNombre()+" actualizada");
                            break;
                        case 3:
                            System.out.println("Selecciona el área de trabajo nueva, elijela por el número");
                            for (int i = 0; i < areas.size(); i++) {
                                System.out.printf(i+".- "+areas.get(i).getNombre()+" Identificador: "+areas.get(i).getIdentificador()+"%n");
                            }
                            int areaSeleccionada = s.nextInt();
                            s.nextLine();
                            Areas areaNueva = areas.get(areaSeleccionada);
                            medicoSeleccionado.cambiarArea(areaNueva);
                            System.out.println("Área de trabajo del médico "+medicoSeleccionado.getNombre()+" actualizada");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }

                    break;
                case 5:
                    if(hospitales.isEmpty()) {
                        System.out.println("No hay hospitales, primero crea uno");
                        break;
                    }
                    Hospital hospitalSeleccionado = buscarHospital();
                    if (hospitalSeleccionado == null) {
                        System.out.println("No hay ningún hospital con ese nombre");
                        break;
                    }

                    System.out.println("Que quieres hacer");
                    System.out.println("1.- Nombre");
                    System.out.println("2.- Dirección");
                    System.out.println("0.- Salir");
                    int opcionHospital = s.nextInt();
                    s.nextLine();

                    switch (opcionHospital) {
                        case 1:
                            System.out.println("Nombre nuevo: ");
                            String nombreNuevo = s.next();
                            hospitalSeleccionado.setNombre(nombreNuevo);
                            System.out.println("Nombre del hospital actualizado");
                            break;
                        case 2:
                            System.out.println("Dirección nueva: ");
                            System.out.println("Calle:");
                            String calle = s.nextLine();
                            System.out.println("Número:");
                            int numero = s.nextInt();
                            s.nextLine();
                            System.out.println("Código postal:");
                            int cp = s.nextInt();
                            s.nextLine();
                            System.out.println("Localidad:");
                            String localidad = s.nextLine();
                            System.out.println("Provincia:");
                            String provincia = s.nextLine();

                            Direccion nuevaDireccion = new Direccion(calle, numero, cp, localidad, provincia);
                            hospitalSeleccionado.setDireccion(nuevaDireccion);
                            System.out.println("Dirección del hospital actualizado");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 6:
                    if(medicos.isEmpty()) {
                        System.out.println("No hay médicos, primero crea uno");
                        break;
                    }
                    Medico medicoSeleccionado6 = buscarMedico();
                    if(medicoSeleccionado6 == null) {
                        System.out.println("No hay ningún médico con ese DNI");
                        break;
                    }

                    System.out.println("Antigüedad del médico "+medicoSeleccionado6.getNombre()+" en el hospital: "+medicoSeleccionado6.getAniosAntiguedad()+" años");

                    break;
                case 7:
                    if(medicos.isEmpty()) {
                        System.out.println("No hay médicos, primero crea uno");
                        break;
                    }
                    Medico medicoSeleccionado7 = buscarMedico();
                    if (medicoSeleccionado7 == null) {
                        System.out.println("No hay ningún médico con ese DNI");
                        break;
                    }

                    Double retencion;
                    do {
                        System.out.println("Introduce el % de retención");
                        retencion = s.nextDouble();
                        if(retencion < 0) {
                            System.out.println("El % de retención no puede ser negativo");
                        }
                    } while (retencion < 0);

                    System.out.println("El sueldo neto del médico "+medicoSeleccionado7.getNombre()+" es: "+medicoSeleccionado7.calcularSueldoNeto(retencion)+"€");
                    break;
                case 8:
                    if(medicos.isEmpty()) {
                        System.out.println("No hay médicos, primero crea uno");
                        break;
                    }
                    Medico medicoSeleccionado8 = buscarMedico();
                    if(medicoSeleccionado8 == null) {
                        System.out.println("No hay ningún médico con ese DNI");
                        break;
                    }

                    int edad;
                    do {
                        System.out.println("Introduce la edad mínima requerida");
                        edad = s.nextInt();
                        s.nextLine();
                        if(edad <= 0) {
                            System.out.println("La edad mínima no puede ser negativo ni 0");
                        }
                    } while(edad <= 0);

                    if(medicoSeleccionado8.esMayorDeEdad(edad) == true) {
                        System.out.println("El médico "+medicoSeleccionado8.getNombre()+" es mayor de edad");
                    } else {
                        System.out.println("El médico "+medicoSeleccionado8.getNombre()+" es menor de edad");
                    }
                    break;
                case 9:
                    if(hospitales.isEmpty()) {
                        System.out.println("No hay hospitales, primero crea uno");
                        break;
                    }
                    Hospital hospitalSeleccionado9 = buscarHospital();
                    if(hospitalSeleccionado9 == null) {
                        System.out.println("No hay ningún hospital con ese nombre");
                        break;
                    }

                    if(areas.isEmpty()) {
                        System.out.println("No hay áreas, primero crea una");
                        break;
                    }
                    Areas areaSeleccionada9 = buscarAreas(hospitalSeleccionado9);
                    if(areaSeleccionada9 == null) {
                        System.out.println("No hay ningún área con ese identificador");
                        break;
                    }

                    System.out.println("La proporción de médicos en el área "+areaSeleccionada9+ " es: "+hospitalSeleccionado9.getProporcionMedicosArea(areaSeleccionada9.getIdentificador()));
                    break;
                case 10:
                    if(hospitales.isEmpty()) {
                        System.out.println("No hay hospitales, primero crea uno");
                        break;
                    }
                    Hospital hospitalSeleccionado10 = buscarHospital();
                    if(hospitalSeleccionado10 == null) {
                        System.out.println("No hay ningún hospital con ese nombre");
                        break;
                    }
                    if(areas.isEmpty()) {
                        System.out.println("No hay áreas, primero crea una");
                        break;
                    }
                    Areas areaSeleccionada10 = buscarAreas(hospitalSeleccionado10);
                    if(areaSeleccionada10 == null) {
                        System.out.println("No hay ningún área con ese identificador");
                        break;
                    }

                    int limite;
                    do {
                        System.out.println("Di el límite máximo del área "+areaSeleccionada10.getNombre());
                        limite = s.nextInt();
                        s.nextLine();
                        if(limite < 0) {
                            System.out.println("El límite máximo no puede ser negativo");
                        }
                    } while(limite < 0);

                    System.out.println("Su capacidad restante es "+areaSeleccionada10.calcularCapacidadRestante(limite));
                    break;
                case 11:
                    if(hospitales.isEmpty()) {
                        System.out.println("No hay hospitales, primero crea uno");
                        break;
                    }
                    System.out.println("Primer Hospital:");
                    Hospital hospital1Seleccionado11 = buscarHospital();
                    if(hospital1Seleccionado11 == null) {
                        System.out.println("No hay ningún hospital con ese nombre");
                        break;
                    }
                    if(areas.isEmpty()) {
                        System.out.println("No hay áreas, primero crea una");
                        break;
                    }
                    System.out.println("Primer área:");
                    Areas area1Seleccionada11 = buscarAreas(hospital1Seleccionado11);
                    if(area1Seleccionada11 == null) {
                        System.out.println("No hay ningún área en el hospital "+area1Seleccionada11.getHospital().getNombre()+" con ese identificador");
                        break;
                    }
                    System.out.println("Segundo Hospital:");
                    Hospital hospital2Seleccionado11 = buscarHospital();
                    if(hospital2Seleccionado11 == null) {
                        System.out.println("No hay ningún hospital con ese nombre");
                        break;
                    }
                    if(areas.isEmpty()) {
                        System.out.println("No hay áreas, primero crea una");
                        break;
                    }
                    System.out.println("Segundo área:");
                    Areas area2Seleccionada11 = buscarAreas(hospital2Seleccionado11);
                    if(area2Seleccionada11 == null) {
                        System.out.println("No hay ningún área en el hospital "+area1Seleccionada11.getHospital().getNombre()+" con ese identificador");
                        break;
                    }

                    area1Seleccionada11.compararMedicos(area2Seleccionada11);
                    break;
                case 12:
                    if(medicos.isEmpty()) {
                        System.out.println("No hay médicos, primero crea uno");
                    }

                    boolean existe;
                    int año;
                    do {
                        existe = false;
                        System.out.println("Di un año para ver los médicos que tienen contrato de ese año");
                        año = s.nextInt();
                        s.nextLine();

                        if(año < 0) {
                            System.out.println("El año no puede ser negativo");
                        } else {
                            existe = true;
                        }
                    } while(!existe);

                    boolean estaenaño = false;
                    for (int i = 0; i < contratos.size(); i++) {
                        if(contratos.get(i).esDeAnio(año)) {
                            System.out.printf("Médico: "+contratos.get(i).getMedico().getNombre()+" Fecha del contrato: "+contratos.get(i).getFechaCreacion()+"%n");
                            estaenaño = true;
                        }
                    }

                    if(!estaenaño) {
                        System.out.println("No hay médicos de ese año");
                    }
                    break;
                case 0:
                    terminar = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!terminar);
    }



}