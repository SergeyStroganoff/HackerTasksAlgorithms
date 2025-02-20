package com.fb;

import java.util.Arrays;

public class ScoreboardInferenceLevel2 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(getMinProblemCount(6, test));
    }

    public static int getMinProblemCount(int N, int[] S) {
        // Write your code here
        int resultCombinationWithTree = 0;
        Arrays.sort(S);
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;

        for (int i = S.length - 1; i >= 0; i--) {
            int tree = S[i] / 3;
            threeCount = Math.max(threeCount, tree);
            int rest = S[i] % 3;
            if (rest != 0) {
                if (rest == 2) {
                    twoCount = 1;
                } else {
                    oneCount = 1;
                }
            }
        }
        resultCombinationWithTree = threeCount + twoCount + oneCount;
        int resultCombinationsTwo = getMinCombinationsWithTwo(S);
        return Math.min(resultCombinationsTwo, resultCombinationWithTree);
    }

    private static int getMinCombinationsWithTwo(int[] S) {
        int maxScore = S[S.length - 1];
        int twoNumbersForMaxScore = maxScore / 2;
        int oneNumberForMaxScore = maxScore % 2;
        int result = twoNumbersForMaxScore + oneNumberForMaxScore;
        if (oneNumberForMaxScore == 0) {
            for (int i = 0; i < S.length - 1; i++) {
                if (S[i] % 2 != 0) {
                    result++;
                    return result;
                }
            }
        }
        return result;
    }
}
