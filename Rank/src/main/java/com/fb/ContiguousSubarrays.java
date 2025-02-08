package com.fb;

import java.util.Arrays;

/**
 * You are given an array arr of N integers. For each index i,
 * you are required to determine the number of contiguous subarrays that fulfill the following conditions:
 * The value at index i must be the maximum element in the contiguous subarrays, and
 * These contiguous subarrays must either start from or end on index i.
 * Signature
 * int[] countSubarrays(int[] arr)
 * Input
 * Array arr is a non-empty list of unique integers that range between 1 and 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
 */

public class ContiguousSubarrays {

    public static void main(String[] args) {
        int[] testArray = {1, 5, 73, 4, 6, 2, 8, 67, 23, 54, 98};
        int[] result = countPossibleArraysWithConditions(testArray);
        System.out.println(Arrays.toString(result));
    }

    private static int[] countPossibleArraysWithConditions(int[] arr) {
        if (arr.length == 0) return new int[0];
        if (arr.length == 1) return new int[]{1};
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int rightIndex = i + 1;
            int leftIndex = i - 1;
            int arrayCounts = 1;
            while (rightIndex < arr.length && arr[i] > arr[rightIndex]) {
                rightIndex++;
                arrayCounts++;
            }
            while (leftIndex >= 0 && arr[i] > arr[leftIndex]) {
                leftIndex--;
                arrayCounts++;
            }

            result[i] = arrayCounts;

        }
        return result;
    }
}
