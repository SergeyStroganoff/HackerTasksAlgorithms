package org.stroganov.sumof_twonumbers;

import java.util.HashSet;
import java.util.Set;

public class TwoNumbersSumSolution {

    public static int[] twoSum(int[] array, int target) {
        int[] resultArray = new int[2];
        if (array.length <= 1) {
            return resultArray;
        }
        Set<Integer> set = new HashSet<>();
        for (int j : array) {
            int subtractionResult = target - j;
            if (set.contains(subtractionResult)) {
                resultArray[0] = j;
                resultArray[1] = subtractionResult;
                return resultArray;
            } else {
                set.add(j);
            }
        }
        return resultArray;
    }
}
