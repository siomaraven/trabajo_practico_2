package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
    public static void main(String[] args) {
        // Creación de un FelinoDomestico
        FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);

        // Definición de la expresión lambda para convertir FelinoDomestico a FelinoSalvaje
        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        // Realizar la conversión
        FelinoSalvaje felino1 = converter.convert(gato);

        // Mostrar los datos del objeto felino salvaje felino1
        converter.mostrarObjeto(felino1);

        // Creación de un FelinoSalvaje
        FelinoSalvaje gatoSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);

        // Verificar que el objeto a convertir no es nulo
        if (Converter.isNotNull(gatoSalvaje)) {
            // Realizar la conversión de FelinoSalvaje a FelinoDomestico
            Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
            // Mostrar los datos del objeto felino doméstico
            converter2.mostrarObjeto(converter2.convert(gatoSalvaje));
        } else {
            System.out.println("El objeto a convertir es nulo.");
        }
    }
}
