package com.fb;

/**
 * Given array of numbers. Find any local min - number which is less or equal
 * left and right neighbours
 */
public class LocalMinimumInArray {

    public static void main(String[] args) {
        int[] test = {98, 28, 700, 22, 100, 20, 12, 21};
        System.out.print(findAnyLocalMinBinarySearch(test));
    }

    /**
     * O(n) - solution
     */
    public static int findAnyLocalMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array[0] <= array[1]) {
            return array[0];
        }
        if (array[array.length - 1] <= array[array.length - 2]) {
            return array[array.length - 1];
        }

        for (int i = 1; i < array.length - 2; i++) {
            if (array[i] <= array[i - 1] && array[i] <= array[i + 1]) {
                return array[i];
            }
        }
        throw new RuntimeException();
    }

    /**
     * BinarySearch method with O(LogN) complexity
     *
     * @param array
     * @return
     */
    public static int findAnyLocalMinBinarySearch(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }

        int left = 0;
        int right = array.length - 1;
        int middle;

        while (left < right) {
            middle = left + (right - left) / 2;
            if ((middle == 0 || array[middle] < array[middle - 1]) &&
                    (middle == array.length - 1 || array[middle] < array[middle + 1])) {
                return array[middle]; // Local minimum found
            }
            if (middle > 0 && array[middle - 1] < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        throw new RuntimeException();
    }

}
