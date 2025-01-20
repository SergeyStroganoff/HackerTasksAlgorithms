package org.simple_algo.find_number_s_arkhipov;

import java.util.Arrays;

/**
 * Поиск пропущенного числа в последовательности путем вычисления разницы сумм
 * Key Features
 * Efficiency: The method uses an 𝑂(𝑛)
 * O(n) approach to calculate the array's sum and an
 * 𝑂(1) O(1) formula to calculate the expected sum, making it very efficient.
 * Scalability: Works with arrays containing large numbers by using long to prevent integer overflow when calculating sums.
 * Readability: Uses concise code with Java Streams for array summation.
 */

public class FindMissedNumberSolution {

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int missedNumber = findMissedNumber(testArray);
        System.out.println(missedNumber);
    }

    private static int findMissedNumber(int[] testArray) {
        int n = testArray.length + 1;
        long sumOfOneToN = (long) n * (n + 1) / 2;
        long sumOfArrayElements = Arrays.stream(testArray).sum();
        return (int) (sumOfOneToN - sumOfArrayElements);
    }

}
