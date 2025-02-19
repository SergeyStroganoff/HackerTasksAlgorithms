package com.fb;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardBruteForce {
    static int minProblems;

    public static boolean canRepresentAll(int[] problems, int[] S) {
        for (int score : S) {
            if (!canFormScore(score, problems)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canFormScore(int score, int[] problems) {
        boolean[] dp = new boolean[score + 1];
        dp[0] = true;
        for (int p : problems) {
            for (int j = score; j >= p; j--) {
                dp[j] |= dp[j - p];
            }
        }
        return dp[score];
    }

    public static int tryAllSubsets(List<Integer> current, int last, int[] S) {
        if (current.size() >= minProblems) return minProblems; // Prune unnecessary checks
        int[] problemSet = current.stream().mapToInt(i -> i).toArray();
        if (canRepresentAll(problemSet, S)) {
            minProblems = Math.min(minProblems, problemSet.length);
        }
        for (int i = last; i <= 3; i++) {
            current.add(i);
            tryAllSubsets(current, i, S);
            current.remove(current.size() - 1);
        }
        return minProblems;
    }

    public static int getMinProblemCount(int n, int[] scores) {
        minProblems = Integer.MAX_VALUE;
        tryAllSubsets(new ArrayList<>(), 1, scores);
        return minProblems;
    }

    public static void main(String[] args) {
        System.out.println(getMinProblemCount(5, new int[]{1, 2, 3, 4, 5})); // Expected: 3
        System.out.println(getMinProblemCount(4, new int[]{2, 4, 6, 8})); // Expected: 4
        System.out.println(getMinProblemCount(3, new int[]{3, 6, 9})); // Expected: 3
        System.out.println(getMinProblemCount(3, new int[]{7, 8, 10})); // Expected: 4
        System.out.println(getMinProblemCount(4, new int[]{1, 1, 1, 1})); // Expected: 1
    }
}

