package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private Double montoPagado;
	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, Double montoPagado) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	@Override
	public void realizarPago (double monto) {
		this.montoPagado = monto + (monto * 0.15);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Pago con tarjeta:");
		System.out.println("Número de tarjeta: " + numeroTarjeta);
		System.out.println("Fecha de pago: " + fechaPago);
		System.out.println("Monto Pagado: " + montoPagado);
	}
}
