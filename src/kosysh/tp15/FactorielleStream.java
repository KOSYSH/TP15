package kosysh.tp15;

import java.util.stream.IntStream;

public class FactorielleStream {
    public static void main(String[] args) {
        System.out.println("Factorielles avec une boucle :");
        IntStream.rangeClosed(0, 10)
                .forEach(nombre -> System.out.println(nombre + "! = " + factorielleImperative(nombre)));

        System.out.println("\nFactorielles avec IntStream :");
        IntStream.rangeClosed(0, 10)
                .forEach(nombre -> System.out.println(nombre + "! = " + factorielleStream(nombre)));
    }

    private static long factorielleImperative(int nombre) {
        verifierNombre(nombre);
        long resultat = 1;
        for (int i = 2; i <= nombre; i++) {
            resultat *= i;
        }
        return resultat;
    }

    private static long factorielleStream(int nombre) {
        verifierNombre(nombre);
        return IntStream.rangeClosed(2, nombre)
                .mapToLong(valeur -> valeur)
                .reduce(1L, (a, b) -> a * b);
    }

    private static void verifierNombre(int nombre) {
        if (nombre < 0 || nombre > 20) {
            throw new IllegalArgumentException("La factorielle accepte un nombre entre 0 et 20");
        }
    }
}
