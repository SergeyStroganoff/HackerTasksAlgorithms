package org.stroganov.tiny_pairs;

import java.util.Arrays;
import java.util.HashSet;

public class Permutations {

    public static void main(String[] args) {
        int number = 1234;
        int swaps = 2;

        System.out.println("Original Number: " + number);
        System.out.println("Permutations with " + swaps + " swaps:");
        generatePermutations(number, swaps);
    }

    public static void generatePermutations(int number, int swaps) {
        char[] digits = Integer.toString(number).toCharArray();
        int length = digits.length;

        if (swaps > length - 1) {
            System.out.println("Invalid number of swaps for the given input.");
            return;
        }
        permute(digits, 0, swaps);
        //   HashSet<Integer> result = new HashSet<>();
        //   permuteIteration(digits, swaps, result);
        //   System.out.println(Arrays.toString(result.toArray()).toString());
    }

    private static void permuteIteration(char[] charArray, int swaps, HashSet<Integer> result) {
        if (swaps == 0) {
            return;
        }
        for (int i = 0; i < charArray.length - 1; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                int number = Integer.parseInt(new String(charArray));
                result.add(number);
                permuteIteration(charArray, swaps - 1, result);
                temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
            }
        }
    }

    private static void permute(char[] digits, int startIndex, int swapsLeft) {
        String message = String.format("Заходим в процедуру permute.  startIndex = %s; swapsLeft = %s;", startIndex, swapsLeft);
        System.out.println(message);
        if (swapsLeft == 0) {
            System.out.println("Пошли на выход из процедуры permute");
            System.out.println(Arrays.toString(digits));
            return;
        }
        for (int i = startIndex; i < digits.length; i++) {
            // Swap elements
            System.out.println("Заходим в цикл.  startIndex = " + startIndex + "; i = " + i + "; swapsLeft = " + swapsLeft);
            char temp = digits[startIndex];
            digits[startIndex] = digits[i];
            digits[i] = temp;

            // Recursively permute the remaining elements
            permute(digits, startIndex + 1, swapsLeft - 1);
            // Undo the swap for backtracking
            System.out.println("Возвращаемся из рекурсии.  startIndex = " + startIndex + "; i = " + i + "; swapsLeft = " + swapsLeft);
            temp = digits[startIndex];
            digits[startIndex] = digits[i];
            digits[i] = temp;
        }
    }
}
