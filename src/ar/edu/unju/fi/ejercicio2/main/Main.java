package ar.edu.unju.fi.ejercicio2.main;

import ar.edu.unju.fi.ejercicio2.model.*;
import ar.edu.unju.fi.ejercicio2.constantes.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Efemeride> efemerides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú de acciones:");
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    crearEfemeride(efemerides, scanner);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(efemerides, scanner);
                    break;
                case 4:
                    modificarEfemeride(efemerides, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor elija nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
        }
	
	private static void crearEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        System.out.println("Creando Efeméride, agregue los siguientes datos...");
        System.out.print("Ingrese2"
        		+ " código: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();
        scanner.nextLine();

        Mes mes;
        do {
            System.out.print("Ingrese el número correspondiente al mes (1 - 12): ");
            int mesNumero = scanner.nextInt();
            scanner.nextLine();

            if (mesNumero < 1 || mesNumero > 12) {
                System.out.println("Mes inválido. Inténtelo de nuevo.");
            } else {
                mes = Mes.values()[mesNumero - 1];
                break;
            }
        } while (true);

        System.out.print("Ingrese el detalle: ");
        String detalle = scanner.nextLine();

        Efemeride nuevaEfemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides.add(nuevaEfemeride);
        System.out.println("Efeméride creada con éxito.");
    }

    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para mostrar.");
            return;
        }
        System.out.println("Listado de Efemérides:");
        for (Efemeride efemeride : efemerides) {
            System.out.println(efemeride);
        }
    }

    private static void eliminarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para eliminar.");
            return;
        }
        System.out.println("Eliminar Efeméride:");
        System.out.print("Ingrese el código de la efeméride a eliminar: ");
        String codigo = scanner.nextLine();
        boolean eliminado = false;
        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo().equals(codigo)) {
                efemerides.remove(efemeride);
                eliminado = true;
                System.out.println("Efeméride eliminada con éxito.");
                break;
            }
        }
        if (!eliminado) {
            System.out.println("No se encontró ninguna efeméride con ese código.");
        }
    }

    private static void modificarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para modificar.");
            return;
        }
        System.out.println("Modificar Efeméride:");
        System.out.print("Ingrese el código de la efeméride a modificar: ");
        String codigo = scanner.nextLine();
        boolean encontrado = false;
        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo().equals(codigo)) {
                encontrado = true;
                System.out.println("Efeméride encontrada:");
                System.out.println(efemeride);
                System.out.print("Ingrese el nuevo día: ");
                int nuevoDia = scanner.nextInt();
                scanner.nextLine();
                efemeride.setDia(nuevoDia);

                Mes nuevoMes;
                do {
                    System.out.print("Ingrese el número correspondiente al nuevo mes (1 - 12): ");
                    int mesNumero = scanner.nextInt();
                    scanner.nextLine();

                    if (mesNumero < 1 || mesNumero > 12) {
                        System.out.println("Mes inválido. Inténtelo de nuevo.");
                    } else {
                        nuevoMes = Mes.values()[mesNumero - 1];
                        efemeride.setMes(nuevoMes);
                        break;
                    }
                } while (true);

                System.out.print("Ingrese el nuevo detalle: ");
                String nuevoDetalle = scanner.nextLine();
                efemeride.setDetalle(nuevoDetalle);

                System.out.println("Efeméride modificada con éxito:");
                System.out.println(efemeride);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ninguna efeméride con ese código.");
        }
    }
}

