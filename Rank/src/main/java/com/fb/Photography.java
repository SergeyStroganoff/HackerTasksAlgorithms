package com.fb;

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
        System.out.println(getArtisticPhotographCount(8, testString2, 1, 3));

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
}
