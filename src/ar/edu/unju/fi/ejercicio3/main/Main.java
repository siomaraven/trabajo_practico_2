package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.*;

public class Main {
	public static void main(String[] args) {
        Provincia[] provincias = Provincia.values();

        System.out.println("Información de Provincias:");
        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia);
            System.out.println("Cantidad de población: " + provincia.getCantidadPoblacion());
            System.out.println("Superficie: " + provincia.getSuperficie());
            System.out.println("Densidad poblacional: " + provincia.calcularDensidadPoblacional() + " habitantes por km^2");
            System.out.println();
        }
    }
}
