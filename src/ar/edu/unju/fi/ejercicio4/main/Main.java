package ar.edu.unju.fi.ejercicio4.main;

import ar.edu.unju.fi.ejercicio4.model.*;
import ar.edu.unju.fi.ejercicio4.constantes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar todos los jugadores");
            System.out.println("3 - Modificar la posición de un jugador");
            System.out.println("4 - Eliminar un jugador");
            System.out.println("5 - Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    altaJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    modificarPosicion(jugadores, scanner);
                    break;
                case 4:
                    eliminarJugador(jugadores, scanner);
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

    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("Alta de Jugador...");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Fecha de nacimiento (yyyy-mm-dd): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Estatura (en metros): ");
        double estatura = scanner.nextDouble();
        System.out.print("Peso (en kilogramos): ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Posiciones:");
        for (Posicion posicion : Posicion.values()) {
            System.out.println(posicion);
        }
        System.out.print("Posición: ");
        Posicion posicion = Posicion.valueOf(scanner.nextLine().toUpperCase());

        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado con éxito.");
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para mostrar.");
            return;
        }
        System.out.println("Listado de Jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para modificar.");
            return;
        }
        System.out.println("Modificar Posición de Jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.nextLine();
        boolean encontrado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Jugador encontrado:");
                System.out.println(jugador);
                System.out.println("Nuevas posiciones:");
                for (Posicion posicion : Posicion.values()) {
                    System.out.println(posicion);
                }
                System.out.print("Nueva posición: ");
                Posicion nuevaPosicion = Posicion.valueOf(scanner.nextLine().toUpperCase());
                jugador.setPosicion(nuevaPosicion);
                System.out.println("Posición modificada con éxito.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
        }
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para eliminar.");
            return;
        }
        System.out.println("Eliminar Jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.nextLine();
        boolean eliminado = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                jugadores.remove(jugador);
                eliminado = true;
                System.out.println("Jugador eliminado con éxito.");
                break;
            }
        }
        if (!eliminado) {
            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
        }
    }

}
