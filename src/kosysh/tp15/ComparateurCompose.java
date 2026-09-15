package kosysh.tp15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparateurCompose {
    private static class Personne {
        private final String nom;
        private final String prenom;
        private final int age;

        Personne(String prenom, String nom, int age) {
            this.prenom = prenom;
            this.nom = nom;
            this.age = age;
        }

        String getNom() {
            return nom;
        }

        String getPrenom() {
            return prenom;
        }

        int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return prenom + " " + nom + " (" + age + " ans)";
        }
    }

    public static void main(String[] args) {
        List<Personne> personnes = Arrays.asList(
                new Personne("Imane", "Alaoui", 39),
                new Personne("Sara", "Bennis", 34),
                new Personne("Amine", "Alaoui", 25),
                new Personne("Mehdi", "Bennis", 27),
                new Personne("Nora", "Alaoui", 31)
        );

        Comparator<Personne> ordreComplet = Comparator
                .comparing(Personne::getNom)
                .thenComparing(Personne::getPrenom)
                .thenComparingInt(Personne::getAge);

        System.out.println("Tri par nom, prenom et age :");
        personnes.stream().sorted(ordreComplet).forEach(System.out::println);

        Comparator<Personne> ordreAvecAgeDecroissant = Comparator
                .comparing(Personne::getNom)
                .thenComparing(Personne::getAge, Comparator.reverseOrder());

        System.out.println("\nTri par nom puis age decroissant :");
        personnes.stream().sorted(ordreAvecAgeDecroissant).forEach(System.out::println);
    }
}
