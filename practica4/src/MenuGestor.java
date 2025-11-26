import java.util.ArrayList;
import java.util.Scanner;

public class MenuGestor {
    private ArrayList<Hospital> hospitales = new ArrayList<>();
    private ArrayList<Direccion> direcciones = new ArrayList<>();
    private ArrayList<Areas> areas = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    Scanner s = new Scanner(System.in);

    public Medico buscarMedico(String dni) {
        if(medicos.isEmpty()) {
            System.out.println("No hay médicos, primero crea uno");
            return null;
        }

        System.out.println("Introduce el DNI");
        dni = s.nextLine();

        Medico medico;
        for (int i = 0; i < medicos.size(); i++) {
            if(medicos.get(i).getDni().equals(dni)) {
                medico = medicos.get(i);
                return medico;
            }
        }

        System.out.println("No hay ningún médico con ese DNI");
        return null;
    }

    public Hospital buscarHospital(String nombre) {
        if(hospitales.isEmpty()) {
            System.out.println("No hay hospitales, primero crea uno");
            return null;
        }

        System.out.println("Introduce el nombre del hospital");
        nombre = s.nextLine();

        Hospital hospital;
        for (int i = 0; i < hospitales.size(); i++) {
            if(hospitales.get(i).getNombre().equals(nombre)) {
                hospital = hospitales.get(i);
                return hospital;
            }
        }

        System.out.println("No hay ningún hospital con ese nombre");
        return null;
    }
    public void crearHospital() {
        System.out.println("Di el nombre del hospital");
        String nombre = s.nextLine();
        boolean existe;
        String cif;
        do {
            existe = false;
            System.out.println("Di el CIF del hospital");
            cif = s.nextLine();

            for (int i = 0; i < hospitales.size(); i++) {
                if (hospitales.get(i).getCif().equals(cif)) {
                    existe = true;
                    System.out.println("El CIF ya existe, pon otro");
                }
            }
        } while (existe);

        System.out.println("Ahora di la dirección del hospital:");
        System.out.println("Di la calle");
        String calle = s.nextLine();
        System.out.println("Di el numero");
        int numero = s.nextInt();
        s.nextLine(); // limpiar buffer
        System.out.println("Di el código postal");
        int codigoPostal = s.nextInt();
        s.nextLine(); // limpiar buffer
        System.out.println("Di la localidad");
        String localidad = s.nextLine();
        System.out.println("Di la provincia");
        String provincia = s.nextLine();

        Direccion nuevaDireccion = new Direccion(calle, numero, codigoPostal, localidad, provincia);
        direcciones.add(nuevaDireccion);
        Hospital nuevoHospital = new Hospital(nombre, cif, nuevaDireccion);
        hospitales.add(nuevoHospital);

        System.out.println("Hospital creado: " + nuevoHospital.getNombre() + " CIF: "+nuevoHospital.getCif());
    }


    public void crearArea() {
        if(hospitales.isEmpty()) {
            System.out.println("No hay hospitales, primero crea uno");
        } else {
            System.out.println("Di el nombre del area");
            String nombre = s.nextLine();
            System.out.println("Di el identificador del área");
            String identificador = s.nextLine();
            System.out.println("Di la planta");
            int planta = s.nextInt();
            System.out.println("Di el hospital por el numero");

            for (int i = 0; i < hospitales.size(); i++) {
                System.out.printf(i + ".- " + hospitales.get(i).getNombre() + " CIF: "+hospitales.get(i).getCif() +"%n");
            }

            int opcion = s.nextInt();
            s.nextLine();

            Hospital seleccion = hospitales.get(opcion);
            Areas nuevoArea = new Areas(nombre, identificador, planta, seleccion);
            areas.add(nuevoArea);
            System.out.println("Área creada: " + nuevoArea);
        }
    }

    public void crearMedico() {
        if(areas.isEmpty()) {
            System.out.println("No hay áreas, primero debes crear uno");
        } else {
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
            System.out.println("Di el área por el número");
            for (int i = 0; i < areas.size(); i++) {
                System.out.printf(i + ".- " + areas.get(i).getNombre() + " Identificador: " + areas.get(i).getIdentificador() + " Hospital: "+ areas.get(i).getHospital().getNombre()+"%n");
            }

            int opcion = s.nextInt();
            s.nextLine();

            Areas seleccion = areas.get(opcion);

            System.out.println("Ahora di la dirección del médico:");
            System.out.println("Di la calle");
            String calle = s.nextLine();
            System.out.println("Di el numero");
            int numero = s.nextInt();
            s.nextLine(); // limpiar buffer
            System.out.println("Di el código postal");
            int codigoPostal = s.nextInt();
            s.nextLine(); // limpiar buffer
            System.out.println("Di la localidad");
            String localidad = s.nextLine();
            System.out.println("Di la provincia");
            String provincia = s.nextLine();

            Direccion nuevaDireccion = new Direccion(calle, numero, codigoPostal, localidad, provincia);
            direcciones.add(nuevaDireccion);
            Medico nuevoMedico = new Medico(dni, nombre, edad, sexo, sueldoBruto, añoInicio, seleccion, nuevaDireccion);
            medicos.add(nuevoMedico);

            Contrato nuevoContrato = new Contrato(añoInicio, nuevoMedico, nuevoMedico.getAreas().getHospital());
            System.out.println("Medico y Contrato creado:");
            System.out.println("Nombre: "+nuevoMedico.getNombre()+" DNI: "+nuevoMedico.getDni()+ " Hospital: "+nuevoMedico.getAreas().getHospital().getNombre());
            System.out.println(nuevoContrato);
        }
    }


    public void menu() {
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
                    Medico medicoSeleccionado = buscarMedico("");
                    if (medicoSeleccionado == null) {
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
                            System.out.println("Área de trabajo nueva, elijela por el número");
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
                    //TENGO QUE CAMBIAR ESTO
                    Hospital hospitalSeleccionado = buscarHospital("");
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
                    Medico medicoSeleccionado6 = buscarMedico("");
                    if(medicoSeleccionado6 == null) {
                        System.out.println("No hay ningún médico con ese DNI");
                        break;
                    }

                    System.out.println("Antigüedad del médico "+medicoSeleccionado6.getNombre()+" en el hospital: "+medicoSeleccionado6.getAniosAntiguedad()+" años");

                    break;
                case 7:
                    Medico medicoSeleccionado7 = buscarMedico("");
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
                    Medico medicoSeleccionado8 = buscarMedico("");
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
                case 0:
                    terminar = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!terminar);
    }



}
