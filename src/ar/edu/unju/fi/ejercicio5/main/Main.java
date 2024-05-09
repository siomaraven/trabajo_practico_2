package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Categoria;
import ar.edu.unju.fi.ejercicio1.model.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = preCargarProductos();
		
		int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Mostrar productos");
            System.out.println("2 – Realizar compra");
            System.out.println("3 – Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    realizarCompra(productos);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
            }
        } while (opcion != 3);

        scanner.close();

	}

	private static ArrayList<Producto> preCargarProductos() {
		ArrayList<Producto> productos = new ArrayList<>();
		productos.add(new Producto("EH001", "Televisor LED 50 pulgadas", 599.99, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR));
        productos.add(new Producto("EH002", "Refrigerador de acero inoxidable", 899.99, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR));
        productos.add(new Producto("EH003", "Lavadora automática de carga frontal", 499.99, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR));
        productos.add(new Producto("EH004", "Microondas con grill", 149.99, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR));
        productos.add(new Producto("EH005", "Aspiradora sin bolsa", 79.99, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR));
        productos.add(new Producto("EH006", "Licuadora de alta potencia", 39.99, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR));
        return productos;
	}
	

	private static void mostrarProductos(ArrayList<Producto> productos) {
		System.out.println("Lista de productos disponibles:");
		
		for (int i = 0; i < 6 && i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
		
	}

	private static void realizarCompra(ArrayList<Producto> productos) {
		Scanner scanner = new Scanner(System.in);
		double totalCompra = 0;
		
		System.out.println("Seleccione su método de pago: ");
		System.out.println("1- Pago en efectivo");
		System.out.println("2- Pago con tarjeta");
		System.out.println("Mi opción es: ");
		int opcionPago = scanner.nextInt();
		
		switch (opcionPago) {
        case 1:
            // para pago en efectivo
            PagoEfectivo pagoEfectivo = new PagoEfectivo(totalCompra, LocalDate.now());
            pagoEfectivo.realizarPago(totalCompra);
            pagoEfectivo.imprimirRecibo();
            break;
        case 2:
            // para pago con tarjeta
            System.out.print("Ingrese el número de tarjeta: ");
            String numeroTarjeta = scanner.next();
            PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), totalCompra);
            pagoTarjeta.realizarPago(totalCompra);
            pagoTarjeta.imprimirRecibo();
            break;
        default:
            System.out.println("Opción inválida. Volviendo al menú principal.");
    }

    scanner.close();
		
	}
}
