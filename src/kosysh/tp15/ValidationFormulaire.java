package kosysh.tp15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

class Validateur<T> {
    private final List<Regle<T>> regles = new ArrayList<Regle<T>>();

    Validateur<T> ajouterRegle(Predicate<T> test, String messageErreur) {
        if (test == null || messageErreur == null || messageErreur.trim().isEmpty()) {
            throw new IllegalArgumentException("La regle est invalide");
        }
        regles.add(new Regle<T>(test, messageErreur));
        return this;
    }

    List<String> valider(T valeur) {
        List<String> erreurs = new ArrayList<String>();
        for (Regle<T> regle : regles) {
            if (!regle.test.test(valeur)) {
                erreurs.add(regle.messageErreur);
            }
        }
        return erreurs;
    }

    private static class Regle<T> {
        private final Predicate<T> test;
        private final String messageErreur;

        Regle(Predicate<T> test, String messageErreur) {
            this.test = test;
            this.messageErreur = messageErreur;
        }
    }
}

public class ValidationFormulaire {
    public static void main(String[] args) {
        Pattern formatEmail = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
        Validateur<String> validateurEmail = new Validateur<String>()
                .ajouterRegle(email -> email != null && !email.trim().isEmpty(),
                        "L'email ne peut pas etre vide")
                .ajouterRegle(email -> email != null && email.contains("@"),
                        "L'email doit contenir @")
                .ajouterRegle(email -> email != null && formatEmail.matcher(email).matches(),
                        "Le format de l'email est invalide");

        List<String> emails = Arrays.asList(
                "imane@formation.ma",
                "",
                "adresse-invalide",
                "mehdi@domaine",
                null
        );

        for (String email : emails) {
            List<String> erreurs = validateurEmail.valider(email);
            String valeurAffichee = email == null ? "null" : email;
            if (erreurs.isEmpty()) {
                System.out.println("Email valide : " + valeurAffichee);
            } else {
                System.out.println("Email invalide : " + valeurAffichee);
                erreurs.forEach(erreur -> System.out.println("- " + erreur));
            }
        }
    }
}
