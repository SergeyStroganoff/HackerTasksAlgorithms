package org.stepik.greatest_subsequence.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    void lengthOfLIS() {
        int[] array = {5, 10, 6, 12, 3, 24, 7, 8};
        SolutionForGreatestSubsequence solution = new SolutionForGreatestSubsequence();
        List<Integer> subsequence = solution.lengthOfLIS(array);
        Assertions.assertEquals(List.of(5, 6, 7, 8), subsequence);
    }

    @Test
    void getGreatestSubSequenceNLLogN() {
        int[] array = {5, 10, 6, 12, 3, 24, 7, 8};
        SolutionForGreatestSubsequence solution = new SolutionForGreatestSubsequence();
        List<Integer> subsequence = solution.getGreatestSubSequenceNLLogN(array);
        Assertions.assertEquals(List.of(5, 6, 7, 8), subsequence);
    }
}