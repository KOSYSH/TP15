package kosysh.tp15;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfacesFonctionnelles {
    public static void main(String[] args) {
        Predicate<String> estVide = texte -> texte == null || texte.trim().isEmpty();
        Consumer<String> afficher = texte -> System.out.println("Message : " + texte);
        Function<String, Integer> compterCaracteres = String::length;
        Supplier<String> fournirModule = () -> "Programmation Java";

        System.out.println("Texte vide : " + estVide.test("   "));
        System.out.println("Texte vide : " + estVide.test("Lambda"));
        afficher.accept("Je teste les interfaces standard");
        System.out.println("Longueur de Casablanca : " + compterCaracteres.apply("Casablanca"));
        System.out.println("Module fourni : " + fournirModule.get());
    }
}
