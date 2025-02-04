package algo.sorting.chosee_sort;

import java.util.Arrays;

public class SortingByChose {

    public static void main(String[] args) {
        int[] testArray = {5, 8, 1, 3, 12, 34, 2};
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexOfPotentialElementToSwap = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexOfPotentialElementToSwap]) {
                    indexOfPotentialElementToSwap = j;
                }
            }
            if (indexOfPotentialElementToSwap != i) {
                swap(array, i, indexOfPotentialElementToSwap);
            }
        }
    }

    private static void swap(int[] array, int i, int k) {
        int temp = array[i];
        array[i] = array[k];
        array[k] = temp;
    }
}
