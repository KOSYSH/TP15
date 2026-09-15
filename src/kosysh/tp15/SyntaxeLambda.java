package kosysh.tp15;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class SyntaxeLambda {
    public static void main(String[] args) {
        Runnable saluer = () -> System.out.println("Salam depuis une lambda sans parametre");
        Consumer<String> afficherSimple = texte -> System.out.println(texte);
        Consumer<String> afficherType = (String texte) -> System.out.println(texte);
        BiFunction<String, String, String> assembler = (gauche, droite) -> gauche + " " + droite;
        BiFunction<Integer, Integer, Integer> maximum = (a, b) -> {
            if (a > b) {
                return a;
            }
            return b;
        };

        saluer.run();
        afficherSimple.accept("Lambda avec un parametre");
        afficherType.accept("Lambda avec un type explicite");
        System.out.println("Texte assemble : " + assembler.apply("Java", "moderne"));
        System.out.println("Maximum entre 27 et 34 : " + maximum.apply(27, 34));
    }
}
