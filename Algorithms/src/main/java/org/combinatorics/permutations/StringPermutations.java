package org.combinatorics.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {
    public static void main(String[] args) {
        List<String> permutations = generatePermutationsNotRecursive("Hello");
        permutations.forEach(System.out::println);
        System.out.println(permutations.size());
        Set<String> permutationsSet = new HashSet<>(permutations);
        permutationsSet.forEach(System.out::println);
        System.out.println(permutationsSet.size());
    }


    public static Set<String> generatePermutations(String str) {
        Set<String> permutations = new HashSet<>();
        generatePermutationsHelper("", str, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String prefix, String remaining, Set<String> permutations) {
        int n = remaining.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutationsHelper(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, n), permutations);
            }
        }
    }

    public static List<String> generatePermutationsNotRecursive(String str) {
        List<String> permutationsList = new ArrayList<>();
        permutationsList.add(""); // Start with an empty string

        for (char c : str.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String perm : permutationsList) {
                for (int i = 0; i <= perm.length(); i++) {
                    String newPerm = perm.substring(0, i) + c + perm.substring(i);
                    newPermutations.add(newPerm);
                }
            }
            permutationsList = newPermutations;
        }

        return permutationsList;
    }

    public static Set<String> myPermitations(String enteredString) {
        final Set<String> resultSet = new HashSet<>();
        generatePermRecursively("", enteredString, resultSet);
        return resultSet;


    }

    private static void generatePermRecursively(String prefix, String enteredString, Set<String> resultSet) {

    }
}

