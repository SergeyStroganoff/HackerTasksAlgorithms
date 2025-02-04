package algo.stepik.greatest_subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SolutionDP {
    public static void main(String[] args) {
        int[] sample = {5, 10, 6, 12, 3, 24, 7, 8, 30};
        int maxSequenceLength = getGreatestSubsequence(sample);
        System.out.println("MAx subsequence is: " + maxSequenceLength);

        System.out.println(returnGreatestSubsequence(sample));

    }

    public static int getGreatestSubsequence(int[] arraySequence) {
        if (arraySequence.length == 1) {
            return 1;
        }
        int[] memory = new int[arraySequence.length];
        int[] prev = new int[arraySequence.length]; //massive for save privies index of element in subsequence
        Arrays.fill(memory, 1);
        for (int i = 0; i < arraySequence.length; i++) {
            for (int j = i + 1; j < arraySequence.length; j++) {
                if (arraySequence[j] > arraySequence[i] && memory[j] < memory[i] + 1) {
                    memory[j] = memory[i] + 1;
                    prev[j] = i; //fill array to get numbers of greatest subsequence
                }
                System.out.println(Arrays.toString(memory));
            }
        }
        System.out.println("Prev array: " + Arrays.toString(prev));
        return Arrays.stream(memory).max().getAsInt();
    }

    public static List<Integer> returnGreatestSubsequence(int[] arraySequence) {
        if (arraySequence.length == 1) {
            return List.of(arraySequence[0]);
        }
        List<Integer> integerList = new ArrayList<>();
        int[] memory = new int[arraySequence.length];
        int[] prev = new int[arraySequence.length]; //massive for save privios index of element in subsequence
        Arrays.fill(memory, 1);
        Arrays.fill(prev, -1);
        System.out.println(Arrays.toString(memory));

        for (int i = 0; i < arraySequence.length; i++) {
            for (int j = i + 1; j < arraySequence.length; j++) {
                if (arraySequence[j] > arraySequence[i] && memory[j] < memory[i] + 1) {
                    memory[j] = memory[i] + 1;
                    prev[j] = i;
                }
                System.out.println(Arrays.toString(memory));
            }
        }
        System.out.println("Prev array: " + Arrays.toString(prev));
        // getting subsequence;

        int indexOfMaxSequenceValue = 0;
        for (int n = 0; n < memory.length; n++) {
            if (memory[n] > memory[indexOfMaxSequenceValue]) {
                indexOfMaxSequenceValue = n;
            }
        }
        while (indexOfMaxSequenceValue != -1) {
            integerList.add(arraySequence[indexOfMaxSequenceValue]);
            indexOfMaxSequenceValue = prev[indexOfMaxSequenceValue];
        }
        Collections.reverse(integerList);
        return integerList;
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
