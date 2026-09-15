package kosysh.tp15;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class Memoizer {
    public static void main(String[] args) {
        AtomicInteger calculsEffectues = new AtomicInteger();
        Function<Integer, Long> fibonacciMemoise = memoize(nombre -> {
            calculsEffectues.incrementAndGet();
            return fibonacci(nombre);
        });

        int rang = 35;
        long debut = System.nanoTime();
        long premierResultat = fibonacciMemoise.apply(rang);
        long premiereDuree = System.nanoTime() - debut;

        debut = System.nanoTime();
        long secondResultat = fibonacciMemoise.apply(rang);
        long secondeDuree = System.nanoTime() - debut;

        System.out.println("Fibonacci(" + rang + ") : " + premierResultat);
        System.out.println("Premier appel : " + premiereDuree + " ns");
        System.out.println("Deuxieme resultat : " + secondResultat);
        System.out.println("Deuxieme appel : " + secondeDuree + " ns");
        System.out.println("Calculs reels effectues : " + calculsEffectues.get());
    }

    public static <T, R> Function<T, R> memoize(Function<T, R> fonction) {
        Objects.requireNonNull(fonction, "La fonction est obligatoire");
        Map<T, R> cache = new ConcurrentHashMap<T, R>();
        return entree -> cache.computeIfAbsent(entree, fonction);
    }

    private static long fibonacci(int nombre) {
        if (nombre < 0) {
            throw new IllegalArgumentException("Le rang doit etre positif");
        }
        if (nombre <= 1) {
            return nombre;
        }
        return fibonacci(nombre - 1) + fibonacci(nombre - 2);
    }
}
