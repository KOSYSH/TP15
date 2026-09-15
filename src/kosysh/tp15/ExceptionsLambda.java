package kosysh.tp15;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface IOFunction<T, R> {
    R apply(T valeur) throws IOException;

    static <T, R> Function<T, R> unchecked(IOFunction<T, R> fonction) {
        return valeur -> {
            try {
                return fonction.apply(valeur);
            } catch (IOException erreur) {
                throw new UncheckedIOException(erreur);
            }
        };
    }
}

public class ExceptionsLambda {
    public static void main(String[] args) {
        Path sources = Paths.get("kosysh", "tp15");
        Path dossier = Files.isDirectory(sources) ? sources : Paths.get(".");

        try (Stream<Path> chemins = Files.list(dossier)) {
            List<String> fichiers = chemins
                    .filter(chemin -> chemin.toString().endsWith(".java"))
                    .map(chemin -> obtenirDescription(chemin))
                    .collect(Collectors.toList());
            System.out.println("Fichiers Java : " + fichiers);
        } catch (IOException erreur) {
            System.err.println("Lecture impossible : " + erreur.getMessage());
        }

        try (Stream<Path> chemins = Files.list(dossier)) {
            List<Long> tailles = chemins
                    .filter(Files::isRegularFile)
                    .filter(chemin -> chemin.toString().endsWith(".java"))
                    .map(IOFunction.unchecked(Files::size))
                    .collect(Collectors.toList());
            System.out.println("Tailles des fichiers : " + tailles);
        } catch (IOException | UncheckedIOException erreur) {
            System.err.println("Calcul des tailles impossible : " + erreur.getMessage());
        }
    }

    private static String obtenirDescription(Path chemin) {
        try {
            return Files.size(chemin) + " octets - " + chemin.getFileName();
        } catch (IOException erreur) {
            return "Erreur - " + chemin.getFileName();
        }
    }
}
