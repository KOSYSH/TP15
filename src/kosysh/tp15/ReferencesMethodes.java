package kosysh.tp15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ReferencesMethodes {
    public static void main(String[] args) {
        Function<String, Integer> convertirEntier = Integer::parseInt;
        Consumer<String> afficher = System.out::println;
        BiFunction<String, String, Boolean> comparer = String::equalsIgnoreCase;
        Supplier<List<String>> creerListe = ArrayList::new;
        Function<Integer, String[]> creerTableau = String[]::new;

        afficher.accept("Nombre converti : " + convertirEntier.apply("2026"));
        afficher.accept("Meme texte : " + comparer.apply("JAVA", "java"));

        List<String> modules = creerListe.get();
        modules.add("Lambda");
        modules.add("Stream");
        afficher.accept("Liste creee : " + modules);

        String[] groupe = creerTableau.apply(4);
        groupe[0] = "Imane";
        afficher.accept("Taille du tableau : " + groupe.length);
        afficher.accept("Premier element : " + groupe[0]);
    }
}
