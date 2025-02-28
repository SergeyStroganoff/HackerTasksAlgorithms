package com.fb;

import java.util.Arrays;

/**
 * Задание: имеется стек поддонов вес которых указан в массиве
 * Стек является стабильным если поддоны лежат друг на друге в порядке
 * уменьшения веса. Что бы стабилизировать стек можно выполнить операцию:
 * <p>
 * Inflate the disc, increasing its radius by 1 inch. This operation takes
 * A seconds and may be performed on discs of any radius (even those that exceed 10 9 inches).
 * Deflate the disc, decreasing its radius by1 inch.
 * This operation takes B seconds and may only be performed if the resulting radius is a positive
 * integer number of inches (that is, if the disc has a radius of at least 2" before being deflated).
 * Determine the minimum number of seconds needed in order to make the stack stable.
 * <p>
 * Найти минимальное количество операций уменьшения веса поддонов.
 */
public class StableStackLevel2 {

    public static void main(String[] args) {
        int[] test1 = {2, 5, 3, 6, 5};
        int[] test2 = {4, 2, 7, 3};
        int[] test3 = {6, 5, 4, 3};
        int[] test4 = {100, 100, 1, 1};
        int[] test5 = {6, 50, 2, 4, 4, 7};
        int[] test6 = {6, 500, 2, 300, 2, 250};
        int[] test7 = {50, 50, 3, 4, 5, 6, 7, 8};
        System.out.println(getMinimumSecondsRequiredDP(6, test6, 1, 1));
        System.out.println(getMinimumSecondsRequiredDP(5, test4, 5, 1));
        System.out.println(getMinimumSecondsRequiredDP(5, test1, 1, 1));
    }


    public static long getMinimumSecondsRequiredDP(int N, int[] R, int A, int B) {
        if (N == 1 || R.length == 1) {
            return 0;
        }
        int maxValue = Arrays.stream(R).max().orElse(0);
        long maxLongValue = Long.MAX_VALUE;
        long[] firstRaw = new long[maxValue + 1];
        Arrays.fill(firstRaw, maxLongValue);
        long[] secondRaw;
        for (int i = 0; i < R.length; i++) {
            secondRaw = new long[firstRaw.length];
            Arrays.fill(secondRaw, maxLongValue);
            long prevMinValue = maxLongValue;
            for (int m = 1 + i; m <= maxValue; m++) {
                prevMinValue = i == 0 ? 0 : Math.min(prevMinValue, firstRaw[m - 1]);
                if (m > i) {
                    int cost = m >= R[i] ? A : B;
                    secondRaw[m] = Math.min(prevMinValue + (long) Math.abs(R[i] - m) * cost, secondRaw[m - 1]);
/*                    if (secondRaw[m]==798){
                        System.out.println("м=  " + m);
                        break;
                    }*/
                }
            }
            firstRaw = secondRaw;
            System.out.println(Arrays.toString(secondRaw));
        }
        return Arrays.stream(firstRaw).min().orElse(Long.MAX_VALUE);
    }


    public static long getMinimumSecondsRequired2(int N, int[] R, int A, int B) {
        if (N == 1 || R.length == 1) {
            return 1;
        }
        int maxValue = Arrays.stream(R).max().orElse(0);
        long[][] dp = new long[R.length][maxValue + 2];
        for (long[] nextRaw : dp) {
            Arrays.fill(nextRaw, 99);
        }
        for (int i = 0; i < R.length; i++) {
            long prevMinValue = 99;
            for (int m = 1; m <= maxValue + 1; m++) {
                prevMinValue = i == 0 ? 0 : Math.min(prevMinValue, dp[i - 1][m - 1]);
                if (m > i) {
                    //long prev = i == 0 ? 0 : getMinInTwoDimensionArray(dp, i - 1, m - 1);
                    int cost = m >= R[i] ? A : B;
                    dp[i][m] = Math.min(prevMinValue + (long) Math.abs(R[i] - m) * cost, dp[i][m - 1]);
                }
            }
        }
        multiDimessialArrayPrint(dp);
        return dp[dp.length - 1][dp[0].length - 1];//getMinInTwoDimensionArray(dp, dp.length - 1, dp[0].length - 1);
    }

    public static long getMinInTwoDimensionArray(long[][] array, int raw, int to) {
        long minVal = Long.MAX_VALUE;
        for (int i = 0; i <= to; i++) {
            if (array[raw][i] < minVal) {
                minVal = array[raw][i];
            }
        }
        return minVal;
    }


    public static void multiDimessialArrayPrint(long[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long[] row : array) {
            for (long colVAAlle : row) {
                System.out.print("| " + colVAAlle + " |");
            }
            System.out.println("\n");
        }
    }
}
