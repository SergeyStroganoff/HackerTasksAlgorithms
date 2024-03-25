package org.stepik.greatest_subsequence;

import java.util.Arrays;


public class SolutionDP {
    public static void main(String[] args) {
        int[] sample = {5, 10, 6, 12, 3, 24, 7, 8};
        int maxSequenceLength = getGreatestSubsequence(sample);

    }

    public static int getGreatestSubsequence(int[] arraySequence) {
        if (arraySequence.length == 1) {
            return 1;
        }
        int[] memory = new int[arraySequence.length];
        Arrays.fill(memory, 1);
        System.out.println(Arrays.toString(memory));

        for (int i = 0; i < arraySequence.length; i++) {
            for (int j = i + 1; j < arraySequence.length; j++) {
                if (arraySequence[j] > arraySequence[i] && memory[j] < memory[i] + 1) {
                    memory[j] = memory[i] + 1;
                }
                System.out.println(Arrays.toString(memory));
            }
        }
        return Arrays.stream(memory).max().getAsInt();
    }


    public static int getGreatestSubsequence2(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
