package algo.simple_algo.two_sorted_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSortedArrayWithTheSameNumber {

    public static void main(String[] args) {
        int[] firstArray = {1, 3, 5, 7, 14, 18, 19, 29, 34, 57, 95, 102};
        int[] secondArray = {0, 3, 4, 6, 8, 10, 11, 12, 15, 17, 18, 19, 21, 22, 34, 56, 78, 95, 102};
        List<Integer> integerList = getCommonNumbers(firstArray, secondArray);
        System.out.println(integerList);
    }

    /**
     * Most effective method O(n+m), memory O(k)
     *
     * @param firstArray
     * @param secondArray
     * @return
     */

    private static List<Integer> getIntersectional(int[] firstArray, int[] secondArray) {
        List<Integer> intersection = new ArrayList<>();
        int pointerFirst = 0;
        int pointerSecond = 0;
        while (pointerFirst < firstArray.length && pointerSecond < secondArray.length) {
            if (firstArray[pointerFirst] == secondArray[pointerSecond]) {
                intersection.add(firstArray[pointerFirst]);
                pointerFirst++;
                pointerSecond++;
            } else {
                if (firstArray[pointerFirst] > secondArray[pointerSecond]) {
                    pointerSecond++;
                } else {
                    pointerFirst++;
                }
            }
        }
        return intersection;
    }

    /**
     * Laconic but worse: O(n*m), memory O(n+m). It uses contains() method under the hood
     *
     * @param firstArray
     * @param secondArray
     * @return
     */
    private static List<Integer> findSameNumbers(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = new ArrayList<>(Arrays.stream(firstArray).boxed().toList());
        firstList.retainAll(Arrays.stream(secondArray).boxed().toList());
        return firstList;
    }

    private static List<Integer> getCommonNumbers(int[] firstArray, int[] secondArray) {
        List<Integer> result = new java.util.ArrayList<>();
        for (int i = 0; i < firstArray.length; i++) {
            int nextValue = firstArray[i];
            if (findEqualsValue(nextValue, secondArray)) {
                result.add(nextValue);
            }
        }
        return result;
    }

    private static boolean findEqualsValue(int nextValue, int[] secondArray) {
        int index = Arrays.binarySearch(secondArray, nextValue);
        return index >= 0;
    }

}

