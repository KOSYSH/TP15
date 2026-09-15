package kosysh.tp15;

import java.util.function.IntUnaryOperator;

public class CaptureLambda {
    private int valeurInterne = 125;

    public static void main(String[] args) {
        int coefficient = 12;
        IntUnaryOperator multiplier = nombre -> nombre * coefficient;

        System.out.println("7 x " + coefficient + " = " + multiplier.applyAsInt(7));
        new CaptureLambda().afficherValeurInterne();
    }

    private void afficherValeurInterne() {
        Runnable action = () -> System.out.println("Valeur de l'objet : " + this.valeurInterne);
        action.run();
    }
}
