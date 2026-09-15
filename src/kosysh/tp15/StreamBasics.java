package kosysh.tp15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasics {
    public static void main(String[] args) {
        List<String> prenoms = Arrays.asList("Imane", "Mehdi", "Meryem", "Sara", "Mounir");

        List<String> prenomsM = prenoms.stream()
                .filter(prenom -> prenom.startsWith("M"))
                .collect(Collectors.toList());

        List<String> majuscules = prenoms.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        long nomsLongs = prenoms.stream()
                .filter(prenom -> prenom.length() > 5)
                .count();

        System.out.println("Prenoms commencant par M : " + prenomsM);
        System.out.println("Prenoms en majuscules : " + majuscules);
        System.out.println("Prenoms de plus de 5 lettres : " + nomsLongs);
    }
}
