package algo.combinatorics.permutations;

import java.util.Set;

public class ImprovedSimplePermutations {
    public static void permute(char[] array, int startIndex, Set<String> resultSet) {
        if (startIndex == array.length - 1) {
            resultSet.add(new String(array)); // Add permutation when startIndex reaches the end
            return;
        }
        for (int i = startIndex; i < array.length; i++) {
            swap(array, startIndex, i); // Swap the current index with the startIndex
            permute(array, startIndex + 1, resultSet); // Recurse with the next index
            swap(array, startIndex, i); // Backtrack to restore the array's original state
        }
    }

    private static void swap(char[] array, int indexOne, int indexTwo) {
        char temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

}
