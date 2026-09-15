package kosysh.tp15;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class InterfacesPrimitives {
    public static void main(String[] args) {
        IntPredicate estPair = nombre -> nombre % 2 == 0;
        IntConsumer afficherNombre = nombre -> System.out.println("Nombre choisi : " + nombre);
        IntFunction<String> convertir = nombre -> "La valeur convertie est " + nombre;
        IntSupplier lancerDe = () -> ThreadLocalRandom.current().nextInt(1, 7);

        System.out.println("15 est pair : " + estPair.test(15));
        System.out.println("24 est pair : " + estPair.test(24));
        afficherNombre.accept(42);
        System.out.println(convertir.apply(125));
        System.out.println("Resultat du de : " + lancerDe.getAsInt());
    }
}
