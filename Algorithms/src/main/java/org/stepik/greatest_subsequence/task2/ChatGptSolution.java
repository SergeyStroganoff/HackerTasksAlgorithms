package org.stepik.greatest_subsequence.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ChatGptSolution {


    public static void main(String[] args) {
        int[] array = {2, 1, 6, 0, 5, 4, 3, 2, 1, 0};
        ArrayList<Integer> maxNonIncreasingSubsequence = findMaxNonIncreasingSubsequence(array);
        System.out.println("Max Non-Increasing Subsequence: " + maxNonIncreasingSubsequence);
    }

    public static ArrayList<Integer> findMaxNonIncreasingSubsequence(int[] array) {
        int n = array.length;
        int[] tailIndices = new int[n];
        int[] prevIndices = new int[n];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (array[i] >= array[tailIndices[len - 1]]) {
                prevIndices[i] = tailIndices[len - 1];
                tailIndices[len++] = i;
            } else if (array[i] < array[tailIndices[0]]) {
                tailIndices[0] = i;
            } else {
                int index = binarySearch(array, tailIndices, 0, len - 1, array[i]);
                prevIndices[i] = tailIndices[index - 1];
                tailIndices[index] = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = tailIndices[len - 1]; i >= 0; i = prevIndices[i]) {
            result.add(array[i]);
        }

        Collections.reverse(result);
        return result;
    }

    public static int binarySearch(int[] array, int[] tailIndices, int left, int right, int key) {
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (array[tailIndices[mid]] <= key) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}



