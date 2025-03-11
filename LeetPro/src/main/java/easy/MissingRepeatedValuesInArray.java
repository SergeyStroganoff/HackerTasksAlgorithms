package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2].
 * Each integer appears exactly once except a which appears twice and b which is missing.
 * The task is to find the repeating and missing numbers a and b.
 * Return a 0-indexed integer array and of size 2 where ans[0] equals to a and ans[1] equals to b.
 */
public class MissingRepeatedValuesInArray {

    public static void main(String[] args) {
        int[][] test = {
                {1, 1},
                {3, 4}
        };
        System.out.println(Arrays.toString(findMissingAndRepeatedValuesMath(test)));
    }


    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] resultBuf = new int[2];
        long gridSum = 0;
        int doubledValue = 0;
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int[] nextRaw : grid) {
            for (int j : nextRaw) {
                gridSum += j;
                integerMap.compute(j, (k, v) -> (v == null) ? 1 : v + 1);
                if (integerMap.get(j) == 2) {
                    doubledValue = j;
                }
            }
        }
        gridSum -= doubledValue;
        int n = (int) Math.pow(grid.length, 2);
        long normalSum = ((long) n * (1 + n)) / 2;
        int missedValue = (int) (normalSum - gridSum);
        resultBuf[0] = doubledValue;
        resultBuf[1] = missedValue;
        return resultBuf;
    }

    public static int[] findMissingAndRepeatedValuesMath(int[][] grid) {
        long realSum = 0;
        long realSquaredSum = 0;
        for (int[] nextRaw : grid) {
            for (int j : nextRaw) {
                realSum += j;
                realSquaredSum += Math.pow(j, 2);

            }
        }
        int n = (int) Math.pow(grid.length, 2);
        long expectSum = ((long) n * (1 + n)) / 2;
        long expectSquaredSum = (n * (n + 1) * (2L * n + 1)) / 6;
        long sumDiff = realSum - expectSum;
        long sqrDiff = realSquaredSum - expectSquaredSum;
        int repeat = (int) (sqrDiff / sumDiff + sumDiff) / 2;
        int missing = (int) (sqrDiff / sumDiff - sumDiff) / 2;
        return new int[]{repeat, missing};
    }
}
