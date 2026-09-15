package kosysh.tp15;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompteurTODO {
    public static void main(String[] args) {
        Path depart = Paths.get(".");
        try (Stream<Path> chemins = Files.walk(depart)) {
            Map<Path, Long> todoParFichier = chemins
                    .filter(Files::isRegularFile)
                    .filter(chemin -> chemin.toString().endsWith(".java"))
                    .collect(Collectors.toMap(
                            chemin -> chemin,
                            CompteurTODO::compterTodo,
                            (premier, second) -> premier,
                            LinkedHashMap::new
                    ));

            System.out.println("Nombre de TODO par fichier Java :");
            todoParFichier.entrySet().stream()
                    .filter(entree -> entree.getValue() > 0)
                    .sorted(Map.Entry.<Path, Long>comparingByValue().reversed())
                    .forEach(entree -> System.out.println(
                            entree.getKey().getFileName() + " : " + entree.getValue()
                    ));

            long total = todoParFichier.values().stream()
                    .mapToLong(Long::longValue)
                    .sum();
            System.out.println("Total des TODO : " + total);
        } catch (IOException | UncheckedIOException erreur) {
            System.err.println("Analyse impossible : " + erreur.getMessage());
        }
    }

    private static long compterTodo(Path fichier) {
        try (Stream<String> lignes = Files.lines(fichier)) {
            return lignes.filter(ligne -> ligne.contains("TODO")).count();
        } catch (IOException erreur) {
            throw new UncheckedIOException(erreur);
        }
    }
}
