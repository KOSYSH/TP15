package kosysh.tp15;

@FunctionalInterface
interface Calculateur {
    int calculer(int a, int b);
}

public class LambdaIntro {
    public static void main(String[] args) {
        afficherIntroduction();
        comparerImplementations();
    }

    static void afficherIntroduction() {
        System.out.println("Bienvenue dans mon TP sur les expressions lambda !");
    }

    static void comparerImplementations() {
        Calculateur additionClassique = new Calculateur() {
            @Override
            public int calculer(int a, int b) {
                return a + b;
            }
        };
        Calculateur additionLambda = (a, b) -> a + b;

        int premierNombre = 14;
        int secondNombre = 9;
        System.out.println("Addition classique : " + additionClassique.calculer(premierNombre, secondNombre));
        System.out.println("Addition avec lambda : " + additionLambda.calculer(premierNombre, secondNombre));
    }
}
