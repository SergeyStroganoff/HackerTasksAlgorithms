package org.stepik.greatest_subsequence.task2;

import java.util.Arrays;

public class binarySearchTraining {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 12, 23, 34, 45, 56, 67, 78, 89, 90, 100, 101};
        Arrays.sort(array);
        int key = 12;
        System.out.println(binarySearch(array, key));
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        int mid = (right - left) / 2;
        while (left <= right) {
            if (key == array[mid]) {
                return mid;
            }
            if (key > array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        return -1;

    }

}
