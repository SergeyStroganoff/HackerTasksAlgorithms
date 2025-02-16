package com.fb;

import java.util.HashMap;
import java.util.HashSet;

/**
 * You are given:
 * A string C of length N, where each character represents a cell in a sequence.
 * Each cell can be one of the following:
 * P: Represents a photographer.
 * A: Represents an actor.
 * B: Represents a backdrop.
 * .: Represents an empty cell (cannot be used).
 * A valid triplet consists of three cells (i, j, k) such that:
 * C[i] = 'P', C[j] = 'A', and C[k] = 'B'.
 * The indices are in order: either i < j < k or i > j > k.
 * A triplet is artistic if:
 * The distance between i and j is between X and Y (inclusive).
 * The distance between j and k is also between X and Y (inclusive).
 * The distance between two indices is the absolute difference: |i - j|.
 * Your task is to count the number of artistic triplets in the string C.
 */

public class Photography {

    public static void main(String[] args) {

        String testString = "PABPBA";
        String testString2 = ".PBAAP.B";
        // System.out.println(getArtisticPhotographCount(6, testString, 1, 3));
        System.out.println(getArtisticPhotographCountEffective(8, testString2, 1, 3));

    }

    public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
        // Write your code here
        int validCombination = getValidCombination(C, X, Y, 'P', 'A', 'B');
        validCombination += getValidCombination(C, X, Y, 'B', 'A', 'P');
        return validCombination;
    }

    private static int getValidCombination(String C, int X, int Y, char first, char second, char third) {
        int result = 0;
        for (int i = 0; i < C.length(); i++) {
            if (C.charAt(i) == first) {
                for (int j = i; j < C.length(); j++) {
                    if (C.charAt(j) == second && X <= j - i && Y >= j - i) {
                        for (int k = j; k < C.length(); k++) {
                            if (C.charAt(k) == third && X <= k - j && Y >= k - j) {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * runs in O(1) on average,
     * but when combined in a loop, the total cost is O(Y - X) per character,
     * leading to O(N * (Y - X)) complexity.
     */

    public static int getArtisticPhotographCountEffective(int N, String C, int X, int Y) {
        // Write your code here
        int validCombination = getValidCombinationEffective(C, X, Y, 'P', 'A', 'B');
        validCombination += getValidCombinationEffective(C, X, Y, 'B', 'A', 'P');
        return validCombination;
    }

    public static int getValidCombinationEffective(String C, int X, int Y, char first, char second, char third) {
        int result = 0;
        HashSet<Integer> pSet = new HashSet<>();
        HashMap<Integer, Integer> aSet = new HashMap<>();
        HashSet<Integer> bSet = new HashSet<>();
        for (int i = 0; i < C.length(); i++) {
            if (C.charAt(i) == first) {
                pSet.add(i);
            } else if (C.charAt(i) == second && !pSet.isEmpty()) {
                for (int n = X; n <= Y; n++) {
                    if (pSet.contains(i - n)) {
                        aSet.merge(i, 1, Integer::sum);
                    }
                }
            } else if (C.charAt(i) == third && (!aSet.isEmpty())) {
                for (int m = X; m <= Y; m++) {
                    if (aSet.containsKey(i - m)) {
                        result += aSet.get(i - m);
                    }
                }
            }
        }
        return result;
    }
}
