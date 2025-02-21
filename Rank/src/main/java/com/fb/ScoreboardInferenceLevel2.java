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
        int firstNumberCase = Integer.MAX_VALUE;
        boolean isAllNumbersEven = Arrays.stream(S).noneMatch(s -> s % 2 == 0);
        boolean isAllNumbersOdd = Arrays.stream(S).allMatch(s -> s % 2 == 0);


        if (S[0] == 1 || isAllNumbersEven) {
            oneCount = 1;
            int treeCount = (S[S.length - 1] - oneCount) / 3;
            int rest = (S[S.length - 1] - oneCount) % 3;
            firstNumberCase = oneCount + treeCount + (rest != 0 ? 1 : 0);
            return firstNumberCase;
        }


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
            if (tree != 0 && twoCount != 0 && oneCount != 0) {
                threeCount--;
            }
        }
        return threeCount + twoCount + oneCount;
        //return Math.min(firstNumberCase, resultCombinationWithTree);
    }

}
