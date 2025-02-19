package com.fb;

import java.util.Arrays;

public class ScoreboardInferenceLevel2 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        System.out.println(getMinProblemCount(6, test));
    }

    public static int getMinProblemCount(int N, int[] S) {
        // Write your code here
        int result;
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
        return threeCount + twoCount + oneCount;
    }


}
