package algo.searching.binary_search;

import java.util.Arrays;

/**
 * Бинарный поиск путем деления каждый раз на два куска
 * Устанавливаем два указателя на начало и на конец массива. В цикле while:
 * Указатель на мидл ставим старт+ (end-start)/2; Если target == midle return midle else
 * target < midle = end = midle -1; else start = midle + 1;
 */

public class BinarySearchSolution {

    public static void main(String[] args) {
        int[] testArray = {1, 5, 3, 9, 2, 56, 34, 36, 11, 10};
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        int index = searchInt(testArray, 56);
        System.out.println(index);
    }

    private static int searchInt(int[] testArray, int target) {
        int start = 0;
        int end = testArray.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (testArray[middle] == target) {
                return middle;
            } else {
                if (target < testArray[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }
}
