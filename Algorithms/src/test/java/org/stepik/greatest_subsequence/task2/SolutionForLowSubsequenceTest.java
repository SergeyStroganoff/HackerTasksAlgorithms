package org.stepik.greatest_subsequence.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionForLowSubsequenceTest {

    @Test
    void getLowestSubSequenceNLLogN_TestTheSameNumbers() {
        int[] array = {2, 20, 20, 20, 20, 20, 20};
        SolutionForLowSubsequence solution = new SolutionForLowSubsequence();
        List<Integer> subsequence = solution.getLowestSubSequenceNLLogN(array);
        Assertions.assertEquals(List.of(2, 3, 4, 5, 6, 7), subsequence);
    }

    @Test
    void getLowestSubSequenceNLLogN() {
        int[] array = {5, 1, 6, 6, 0, 5, 4, 8, 8, 2, 1, 0, 5};
        SolutionForLowSubsequence solution = new SolutionForLowSubsequence();
        List<Integer> subsequence = solution.getLowestSubSequenceNLLogN(array);
        Assertions.assertEquals(List.of(3, 4, 6, 7, 10, 11, 12), subsequence);
    }

    @Test
    void getLowestSubSequenceNLLogN_Test7() {
        int[] array = {2, 3, 1, 2, 1, 3, 2, 1, 1, 2};
        SolutionForLowSubsequence solution = new SolutionForLowSubsequence();
        List<Integer> subsequence = solution.getLowestSubSequenceNLLogN(array);
        Assertions.assertEquals(List.of(2, 6, 7, 8, 9), subsequence);
    }

    @Test
    void getLowestSubSequenceNLLogN_Test16() {
        int[] array = {5, 8, 5, 7, 4, 7, 4, 6, 3, 6, 20, 20, 20, 20, 20, 20};
        SolutionForLowSubsequence solution = new SolutionForLowSubsequence();
        List<Integer> subsequence = solution.getLowestSubSequenceNLLogN(array);
        Assertions.assertEquals(List.of(11, 12, 13, 14, 15, 16), subsequence);
    }
}