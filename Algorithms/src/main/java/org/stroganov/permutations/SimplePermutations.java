package org.stroganov.permutations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimplePermutations {

    public static void main(String[] args) {
        String s = "Hello";
        Set<String> resultSet = new HashSet<>();
        permute(s.toCharArray(), 0, resultSet);
        print("Total Result: __________________________");
        resultSet.forEach(SimplePermutations::print);
        print(String.valueOf(resultSet.size()));
    }


    public static void permute(char[] array, int startIndex, Set<String> resultSet) {
        for (int i = startIndex; i < array.length; i++) {
            resultSet.add(Arrays.toString(array));
            for (int j = i + 1; j < array.length; j++) {
                swap(array, i, j);
                permute(array, startIndex + 1, resultSet);
                swap(array, i, j);
            }
        }
    }


    private static void swap(char[] array, int indexOne, int indexTwo) {
        char temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;

    }

    private static void print(String message) {
        System.out.println(message);
    }
}



