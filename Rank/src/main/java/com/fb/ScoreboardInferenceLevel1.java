package com.fb;

import java.util.Arrays;

/**
 * You are spectating a programming contest with N competitors,
 * each trying to independently solve the same set of programming problems.
 * Each problem has a point value, which is either 1 or 2.
 * On the scoreboard, you observe that the i
 * ith competitor has attained a score of Si
 * , which is a positive integer equal to the sum of the point values of all the problems they have solved.
 * The scoreboard does not display the number of problems in the contest, nor their point values. Using the information available, you would like to determine the minimum possible number of problems in the contest.
 */

public class ScoreboardInferenceLevel1 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6};
        System.out.println(getMinProblemCount(6, test));
    }

    public static int getMinProblemCount(int N, int[] S) {
        // Write your code here
        int result = 0;
        Arrays.sort(S);
        int maxScore = S[S.length - 1];
        int twoNumbersForMaxScore = maxScore / 2;
        int oneNumberForMaxScore = maxScore % 2;
        result = twoNumbersForMaxScore + oneNumberForMaxScore;
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
