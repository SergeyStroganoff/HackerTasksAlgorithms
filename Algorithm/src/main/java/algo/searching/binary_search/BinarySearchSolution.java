package algo.searching.binary_search;

import java.util.Arrays;

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
        int end = testArray.length;
        while (start < end) {
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
