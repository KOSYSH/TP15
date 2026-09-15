package kosysh.tp15;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
interface TriFunction<A, B, C, R> {
    R apply(A a, B b, C c);

    default <V> TriFunction<A, B, C, V> andThen(Function<? super R, ? extends V> suite) {
        Objects.requireNonNull(suite, "La fonction suivante est obligatoire");
        return (a, b, c) -> suite.apply(apply(a, b, c));
    }
}

public class TriFunctionDemo {
    public static void main(String[] args) {
        TriFunction<Double, Double, Double, Double> volume =
                (longueur, largeur, hauteur) -> longueur * largeur * hauteur;
        TriFunction<Double, Double, Double, String> volumeEnLitres = volume
                .andThen(metresCubes -> metresCubes * 1000)
                .andThen(litres -> String.format("%.0f litres", litres));

        double longueur = 2.5;
        double largeur = 1.8;
        double hauteur = 1.2;
        System.out.printf("Volume : %.2f m3%n", volume.apply(longueur, largeur, hauteur));
        System.out.println("Volume converti : " + volumeEnLitres.apply(longueur, largeur, hauteur));
    }
}
