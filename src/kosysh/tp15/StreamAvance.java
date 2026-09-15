package kosysh.tp15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAvance {
    private static class Personne {
        private final String nom;
        private final int age;
        private final String ville;

        Personne(String nom, int age, String ville) {
            if (nom == null || nom.trim().isEmpty() || ville == null || ville.trim().isEmpty()) {
                throw new IllegalArgumentException("Le nom et la ville sont obligatoires");
            }
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("L'age est invalide");
            }
            this.nom = nom.trim();
            this.age = age;
            this.ville = ville.trim();
        }

        String getNom() {
            return nom;
        }

        int getAge() {
            return age;
        }

        String getVille() {
            return ville;
        }

        @Override
        public String toString() {
            return nom + " (" + age + " ans) - " + ville;
        }
    }

    public static void main(String[] args) {
        List<Personne> personnes = Arrays.asList(
                new Personne("Imane", 23, "Casablanca"),
                new Personne("Mehdi", 29, "Rabat"),
                new Personne("Sara", 26, "Casablanca"),
                new Personne("Amine", 34, "Marrakech"),
                new Personne("Nora", 31, "Rabat")
        );

        Map<String, List<Personne>> parVille = personnes.stream()
                .collect(Collectors.groupingBy(Personne::getVille));
        double ageMoyen = personnes.stream()
                .mapToInt(Personne::getAge)
                .average()
                .orElse(0);
        Personne plusAgee = personnes.stream()
                .max(Comparator.comparingInt(Personne::getAge))
                .orElse(null);
        List<String> casablancais = personnes.stream()
                .filter(personne -> personne.getVille().equals("Casablanca"))
                .map(Personne::getNom)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Personnes groupees par ville : " + parVille);
        System.out.printf("Age moyen : %.1f%n", ageMoyen);
        System.out.println("Personne la plus agee : " + plusAgee);
        System.out.println("Habitants de Casablanca : " + casablancais);
    }
}
