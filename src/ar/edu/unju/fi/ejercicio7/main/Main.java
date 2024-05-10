package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto;

public class Main {

	public static void main(String[] args) {
		 List<Producto> productos = precargarProductos();
	        Scanner scanner = new Scanner(System.in);

	        int opcion;
	        do {
	            mostrarMenu();
	            opcion = scanner.nextInt();
	            switch (opcion) {
	                case 1:
	                    mostrarProductos(productos);
	                    break;
	                case 2:
	                    mostrarProductosFaltantes(productos);
	                    break;
	                case 3:
	                    List<Producto> productosIncrementados = incrementarPrecios(productos);
	                    mostrarProductos(productosIncrementados);
	                    break;
	                case 4:
	                    mostrarProductosElectrohogarDisponibles(productos);
	                    break;
	                case 5:
	                    ordenarProductosPorPrecioDescendente(productos);
	                    mostrarProductos(productos);
	                    break;
	                case 6:
	                    mostrarNombresEnMayusculas(productos);
	                    break;
	                case 0:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        } while (opcion != 0);
	        
	        scanner.close();
	    }

	    private static List<Producto> precargarProductos() {
	        List<Producto> productos = new ArrayList<>();
	        productos.add(new Producto("Licuadora Multifuncional", "Electrohogar", 43503.99, true));
	        productos.add(new Producto("Taladro Inalámbrico Profesional", "Herramientas", 1213550.0, false));
	        productos.add(new Producto("Aspiradora Robotizada Inteligente", "Electrohogar", 123456.0, true));
	        productos.add(new Producto("Juego de Destornilladores de Precisión", "Herramientas", 93240.0, true));
	        productos.add(new Producto("Plancha de Vapor con Control de Temperatura", "Electrohogar", 18230.0, false));
	        productos.add(new Producto("Sierra Circular Compacta de Alta Potencia", "Herramientas", 220112.0, true));
	        productos.add(new Producto("Cortadora de Césped Eléctrica Autopropulsada", "Electrohogar", 1301234.0, true));
	        productos.add(new Producto("Juego de Llaves Allen Hexagonales de Acero", "Herramientas", 1602134.0, false));
	        productos.add(new Producto("Robot de Cocina Programable con 10 Funciones", "Electrohogar", 212340.0, true));
	        productos.add(new Producto("Pistola de Calor de Alta Potencia", "Herramientas", 1121340.0, true));
	        productos.add(new Producto("Cafetera de Goteo Programable con Jarra Térmica", "Electrohogar", 170123.0, false));
	        productos.add(new Producto("Juego de Brocas para Madera y Metal", "Herramientas", 1234260.0, true));
	        productos.add(new Producto("Horno Eléctrico de Convección con Grill", "Electrohogar", 140123.0, true));
	        productos.add(new Producto("Máquina para Pulir y Encerar Automóviles", "Herramientas", 112290.0, false));
	        productos.add(new Producto("Batidora de Mano de Alta Potencia con Accesorios", "Electrohogar", 280123.0, true));
	        
	        return productos;
	    }

	    private static void mostrarMenu() {
	        System.out.println(">>>> MENÚ: ");
	        System.out.println("1 - Mostrar productos (solo se muestran los productos con estado true)");
	        System.out.println("2 - Mostrar los productos faltantes (muestra productos con estado false)");
	        System.out.println("3 - Incrementar los precios de los productos en un 20%");
	        System.out.println("4 - Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta");
	        System.out.println("5 - Ordenar los productos por precio de forma descendente");
	        System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
	        System.out.println("0 - Salir");
	        System.out.print("Seleccione una opción: ");
	    }

	    private static void mostrarProductos(List<Producto> productos) {
	        System.out.println("Productos disponibles:");
	        productos.stream()
	                .filter(Producto::isEstado)
	                .forEach(System.out::println);
	    }

	    private static void mostrarProductosFaltantes(List<Producto> productos) {
	        System.out.println("Productos faltantes:");
	        productos.stream()
	                .filter(producto -> !producto.isEstado())
	                .forEach(System.out::println);
	    }

	    private static List<Producto> incrementarPrecios(List<Producto> productos) {
	        return productos.stream()
	                .map(producto -> {
	                    producto.setPrecio(producto.getPrecio() * 1.2); // incrementamos el precio en un 20%
	                    return producto;
	                })
	                .collect(Collectors.toList());
	    }

	    private static void mostrarProductosElectrohogarDisponibles(List<Producto> productos) {
	        System.out.println("Productos de Electrohogar disponibles para la venta:");
	        Predicate<Producto> electrohogarDisponible = producto ->
	                producto.getCategoria().equals("Electrohogar") && producto.isEstado();
	        productos.stream()
	                .filter(electrohogarDisponible)
	                .forEach(System.out::println);
	    }

	    private static void ordenarProductosPorPrecioDescendente(List<Producto> productos) {
	        System.out.println("Productos ordenados por precio de forma descendente:");
	        Comparator<Producto> comparadorPorPrecioDescendente = Comparator.comparingDouble(Producto::getPrecio).reversed();
	        productos.sort(comparadorPorPrecioDescendente);
	    }

	    private static void mostrarNombresEnMayusculas(List<Producto> productos) {
	        System.out.println("Nombres de productos en mayúsculas:");
	        Function<Producto, String> nombreEnMayusculas = producto ->
	                producto.getNombre().toUpperCase();
	        productos.stream()
	                .map(nombreEnMayusculas)
	                .forEach(System.out::println);
	    }
	}
