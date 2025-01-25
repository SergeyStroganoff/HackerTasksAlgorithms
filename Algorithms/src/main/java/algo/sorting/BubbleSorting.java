package algo.sorting;

import java.util.Arrays;

public class BubbleSorting {

    public static void main(String[] args) {
        int[] testArray = {5, 8, 1, 3, 12, 34, 2};
        bubbleSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    private static void bubbleSort(int[] testArray) {
        for (int i = 0; i < testArray.length; i++) {
            for (int j = i; j < testArray.length; j++) {
                if (testArray[i] < testArray[j]) {  //reverse sorting
                    swap(testArray, i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int k) {
        int temp = array[i];
        array[i] = array[k];
        array[k] = temp;
    }
}
