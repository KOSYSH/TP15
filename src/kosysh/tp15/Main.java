package kosysh.tp15;

public class Main {
    public static void main(String[] args) {
        executer("Etape 1 - Introduction", arguments -> LambdaIntro.afficherIntroduction());
        executer("Etape 2 - Premiere lambda", arguments -> LambdaIntro.comparerImplementations());
        executer("Etape 3 - Interfaces standard", InterfacesFonctionnelles::main);
        executer("Etape 4 - Interfaces primitives", InterfacesPrimitives::main);
        executer("Etape 5 - Syntaxes lambda", SyntaxeLambda::main);
        executer("Etape 6 - Capture de variables", CaptureLambda::main);
        executer("Etape 7 - References de methodes", ReferencesMethodes::main);
        executer("Etape 8 - Stream simple", StreamBasics::main);
        executer("Etape 9 - Stream avance", StreamAvance::main);
        executer("Etape 10 - Composition", CompositionFonctions::main);
        executer("Etape 11 - Exceptions", ExceptionsLambda::main);
        executer("Etape 12 - Validation", ValidationFormulaire::main);
        executer("Etape 13 - TriFunction", TriFunctionDemo::main);
        executer("Etape 14 - Compteur TODO", CompteurTODO::main);
        executer("Etape 15 - Comparateurs", ComparateurCompose::main);
        executer("Etape 16 - Factorielle", FactorielleStream::main);
        executer("Etape 17 - Memoizer", Memoizer::main);
        System.out.println("\n=== Fin des 17 etapes du TP15 ===");
    }

    private static void executer(String titre, LanceurEtape lanceur) {
        System.out.println("\n=== " + titre + " ===");
        try {
            lanceur.lancer(new String[0]);
        } catch (RuntimeException erreur) {
            System.err.println("Etape interrompue : " + erreur.getMessage());
        }
    }

    @FunctionalInterface
    private interface LanceurEtape {
        void lancer(String[] args);
    }
}
