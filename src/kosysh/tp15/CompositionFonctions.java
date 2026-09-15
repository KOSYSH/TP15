package kosysh.tp15;

import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionFonctions {
    public static void main(String[] args) {
        Function<String, Integer> longueur = String::length;
        Function<Integer, Boolean> longueurPaire = nombre -> nombre % 2 == 0;
        Function<String, Boolean> testerApresLongueur = longueur.andThen(longueurPaire);
        Function<String, Boolean> testerAvecCompose = longueurPaire.compose(longueur);

        Predicate<String> commenceParJ = texte -> texte.startsWith("J");
        Predicate<String> contientSixCaracteres = texte -> texte.length() >= 6;

        System.out.println("Longueur de Java paire : " + testerApresLongueur.apply("Java"));
        System.out.println("Longueur de Lambda paire : " + testerAvecCompose.apply("Lambda"));
        System.out.println("JavaFX commence par J et contient 6 caracteres : "
                + commenceParJ.and(contientSixCaracteres).test("JavaFX"));
        System.out.println("Stream commence par J ou contient 6 caracteres : "
                + commenceParJ.or(contientSixCaracteres).test("Stream"));
        System.out.println("Lambda ne commence pas par J : " + commenceParJ.negate().test("Lambda"));
    }
}
