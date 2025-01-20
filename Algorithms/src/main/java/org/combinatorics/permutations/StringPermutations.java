package org.combinatorics.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {
    public static void main(String[] args) {
        List<String> permutations = generatePermutationsNotRecursiveImproved("Hello");
        permutations.forEach(System.out::println);
        System.out.println(permutations.size());
        Set<String> permutationsSet = new HashSet<>(permutations);
        permutationsSet.forEach(System.out::println);
        System.out.println(permutationsSet.size());
    }

    public static List<String> generatePermutationsNotRecursiveImproved(String str) {
        Set<String> permutationsSet = new HashSet<>();
        permutationsSet.add(""); // Start with an empty string 1 element to start iteration

        for (char c : str.toCharArray()) {
            Set<String> newPermutations = new HashSet<>();
            for (String currentPermString : permutationsSet) { // берем следующую строку и внедряем нашу букву снова по всей строке
                for (int i = 0; i <= currentPermString.length(); i++) {
                    // i=0 char c='H'
                    // двигаемся по сету окном и вставляем наш символ во все места
                    String newPerm = currentPermString.substring(0, i) + c + currentPermString.substring(i);
                    // наращиваем результат
                    newPermutations.add(newPerm);
                }
            }
            permutationsSet = newPermutations;
        }

        return new ArrayList<>(permutationsSet);
    }


}

