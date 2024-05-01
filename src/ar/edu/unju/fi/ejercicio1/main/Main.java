package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        
        do {
        	System.out.println("Menú de opciones:");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearProducto(productos, scanner);
                    break;
                case 2:
                    mostrarProductos(productos);
                    break;
                case 3:
                    modificarProducto(productos, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor elija nuevamente.");
            }
        } while (opcion != 4);
        
        scanner.close();
        }
	private static void crearProducto(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("Creando Producto...");
        System.out.print("Ingrese el código: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio unitario: ");
        double precioUnitario = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("---- Origen de fabricación -----");
        for (int i = 0; i < OrigenFabricacion.values().length; i++) {
            System.out.println((i + 1) + " - " + OrigenFabricacion.values()[i]);
        }
        System.out.print("Elija una opción: ");
        int origenIndex = scanner.nextInt();
        OrigenFabricacion origenFabricacion = OrigenFabricacion.values()[origenIndex - 1];
        scanner.nextLine();

        System.out.println("------ Categoría ------");
        for (int i = 0; i < Categoria.values().length; i++) {
            System.out.println((i + 1) + " - " + Categoria.values()[i]);
        }
        System.out.print("Elija una opción: ");
        int categoriaIndex = scanner.nextInt();
        Categoria categoria = Categoria.values()[categoriaIndex - 1];
        scanner.nextLine();

        Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
        productos.add(nuevoProducto);
        System.out.println("Producto creado con éxito.");
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
            return;
        }
        System.out.println("Listado de Productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void modificarProducto(ArrayList<Producto> productos, Scanner scanner) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para modificar.");
            return;
        }
        System.out.println("Modificar Producto:");
        System.out.println("Ingrese el código del producto a modificar: ");
        String codigo = scanner.nextLine();
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                encontrado = true;
                System.out.println("Producto encontrado:");
                System.out.println(producto);
                System.out.println("¿Qué desea modificar?");
                System.out.println("1 - Descripción");
                System.out.println("2 - Precio Unitario");
                System.out.println("3 - Origen de Fabricación");
                System.out.println("4 - Categoría");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la nueva descripción: ");
                        String nuevaDescripcion = scanner.nextLine();
                        producto.setDescripcion(nuevaDescripcion);
                        break;
                    case 2:
                        System.out.print("Ingrese el nuevo precio unitario: ");
                        double nuevoPrecio = scanner.nextDouble();
                        producto.setPrecioUnitario(nuevoPrecio);
                        break;
                    case 3:
                        System.out.println("---- Origen de fabricación -----");
                        for (int i = 0; i < OrigenFabricacion.values().length; i++) {
                            System.out.println((i + 1) + " - " + OrigenFabricacion.values()[i]);
                        }
                        System.out.print("Elija una opción: ");
                        int origenIndex = scanner.nextInt();
                        OrigenFabricacion nuevoOrigen = OrigenFabricacion.values()[origenIndex - 1];
                        scanner.nextLine();
                        producto.setOrigenFabricacion(nuevoOrigen);
                        break;
                    case 4:
                        System.out.println("------ Categoría ------");
                        for (int i = 0; i < Categoria.values().length; i++) {
                            System.out.println((i + 1) + " - " + Categoria.values()[i]);
                        }
                        System.out.print("Elija una opción: ");
                        int categoriaIndex = scanner.nextInt();
                        Categoria nuevaCategoria = Categoria.values()[categoriaIndex - 1];
                        scanner.nextLine(); 
                        producto.setCategoria(nuevaCategoria);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                System.out.println("Producto modificado con éxito:");
                System.out.println(producto);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún producto con ese código.");
        }
    }
}