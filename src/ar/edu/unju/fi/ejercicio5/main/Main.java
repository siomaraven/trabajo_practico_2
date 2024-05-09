package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {
 
	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<>();
		ArrayList<Producto> carrito = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        precargarProductos(productos);
        do {
            System.out.println(">>>> MENU DE OPCIONES <<<<");
            System.out.println("1- Mostrar productos");
            System.out.println("2- Realizar compra");
            System.out.println("3- Salir");
            System.out.print("Seleccione una opcion: ");
            try {
	            opcion = scanner.nextInt();
	           
	            switch (opcion) {
	                case 1:
	                    mostrarProductos(productos, scanner);
	                    break;
	                case 2:
	                    realizarCompra(productos, carrito, scanner);
	                    break;
	                case 3:
	                    System.out.println("Saliendo de la tienda");
	                    break;
	                default:
	                    System.out.println("Opcion no valida, intentelo de nuevo.");
	            }
            } catch (Exception e) {
                System.out.println("Error: ingrese un numero entero valido.");
                scanner.nextLine();
                opcion = 0; //Forzar repeticion del menu.
            }
        } while (opcion != 3);

		

	}
	public static void precargarProductos(ArrayList<Producto> productos) {
		if (productos.isEmpty()) {
		    productos.add(new Producto("1", "Microondas Philips", 1000500, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false));
	        productos.add(new Producto("2", "Samsung S23", 1320000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
	        productos.add(new Producto("3", "Laptop HP", 2500000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("4", "Taladro Black & Decker", 80000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
	        productos.add(new Producto("5", "TV LG", 1500000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("6", "Mouse Logitech", 30000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("7", "Cafetera Oster", 70000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
	        productos.add(new Producto("8", "Horno eléctrico", 120000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("9", "Impresora SAMSUNG", 90000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("10", "Destornillador Stanley", 50000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
	        productos.add(new Producto("11", "Refrigerador Mabe", 1100000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
	        productos.add(new Producto("12", "Router TP-Link", 60000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	        productos.add(new Producto("13", "Aspiradora Electrolux", 85000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("14", "Destornillador Phillips", 20000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
	        productos.add(new Producto("15", "Heladera Philips", 1000500, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, false));
		}
		
	}
	
	public static void mostrarProductos(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("- LISTA DE PRODUCTOS: ");
        for (Producto i : productos) {
            System.out.println(i.toString());
        } 
    }
		 public static void realizarCompra(ArrayList<Producto> productos, ArrayList<Producto> carrito, Scanner scanner) {
			 	boolean bandera=true;
			 	while(bandera) {
					 System.out.println("Desea agregar algun producto al carrito? (S/s o N/n):");
					 String respuesta = scanner.next();
					  if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("S")) {
			            System.out.println("Ingrese el numero del producto que desea agregar al carrito:");
			            
			            int indiceProducto = scanner.nextInt();
			            scanner.nextLine();
	
			            if (indiceProducto >= 1 && indiceProducto <= productos.size()) {
			                Producto productoSeleccionado = productos.get(indiceProducto - 1);
			                carrito.add(productoSeleccionado);
			                System.out.println(productoSeleccionado.getDescripcion() + " ha sido agregado al carrito.");
			            } else {
			                System.out.println("Numero de producto invalido.");
			            }
			       
					  }else {
						  if(respuesta.equalsIgnoreCase("n") || respuesta.equalsIgnoreCase("N")) {
							  bandera=false;
						  }else
							  System.out.println("Respuesta mal ingresada intentelo denuevo.");
						  }
					  
						  
			 	}
		        double totalCompra = calcularTotal(carrito);
		        
		        System.out.println("El total de la compra es: $" + totalCompra);
		        System.out.println("Seleccione el metodo de pago:");
		        System.out.println("1- Pago efectivo");
		        System.out.println("2- Pago con tarjeta");
		        System.out.print("Opción de pago: ");
		        int opcionPago = scanner.nextInt();

		        try {
		            switch (opcionPago) {
		                case 1:
		                    PagoEfectivo pagoEfectivo = new PagoEfectivo(totalCompra, LocalDate.now());
		                    pagoEfectivo.realizarPago(totalCompra);
		                    pagoEfectivo.imprimirRecibo();
		                    break;
		                case 2:
		                    System.out.print("Ingrese el numero de tarjeta: ");
		                    String numeroTarjeta = scanner.next();
		                    PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta,LocalDate.now(), totalCompra);
		                    pagoTarjeta.realizarPago(totalCompra);
		                    pagoTarjeta.imprimirRecibo();
		                    break;
		                default:
		                    System.out.println("Opcion de pago no valida/inexistente");
		            }
		        } catch (Exception e) {
		            System.out.println("Error al procesar el pago");
		        }
		    }
			 

		    public static double calcularTotal(ArrayList<Producto> carrito) {
		        double total = 0;
		        for (Producto producto : carrito) {
		            total += producto.getPrecioUnitario();
		        }
		        return total;
		    }  
	    

}