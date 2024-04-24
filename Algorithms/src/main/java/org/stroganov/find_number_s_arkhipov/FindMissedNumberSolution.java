package org.stroganov.find_number_s_arkhipov;

import java.util.Arrays;

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
