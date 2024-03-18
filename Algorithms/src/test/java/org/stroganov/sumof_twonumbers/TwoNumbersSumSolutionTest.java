package org.stroganov.sumof_twonumbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoNumbersSumSolutionTest {

    @Test
    void twoSum() {
        int[] nums = new int[]{2, 8, 11, 15, 2, 18, 3, 5, 8, 35, 45, 12, 11, 24};
        int[] result = TwoNumbersSumSolution.twoSum(nums, 33);
        Arrays.stream(result).forEach(System.out::println);
        assert result[0] == 18;
        assert result[1] == 15;
    }
}