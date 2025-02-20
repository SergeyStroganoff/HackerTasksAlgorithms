package com.fb;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardBruteForce {
    public static void main(String[] args) {
        System.out.println(getMinProblemCount(5, new int[]{1, 2, 3, 4, 5})); // Expected: 3
        System.out.println(getMinProblemCount(4, new int[]{2, 4, 6, 8})); // Expected: 4
        System.out.println(getMinProblemCount(3, new int[]{3, 6, 9})); // Expected: 3
        System.out.println(getMinProblemCount(3, new int[]{7, 8, 10})); // Expected: 4
        System.out.println(getMinProblemCount(4, new int[]{1, 1, 1, 1})); // Expected: 1
        System.out.println(getMinProblemCount(4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})); // Expected: 1
    }

    public static int getMinProblemCount(int n, int[] scores) {
        return tryAllSubsets(new ArrayList<>(), 1, scores, Integer.MAX_VALUE);
    }

    /*
   Рекурсия передаем сет-набор задач для удовлетворения всем оценкам
   если набор больше чем уже найденное решение с минимальным размером сразу отсекаем и выходим из процедуры
   проверяем если с новым входным набором мы сможем представить набор оценок
   то обновляем минимальный набор Math.min
   далее обновляем наш набор методом добавления в набор еще одной цифры и вызываем рекурсивно сами себя
   при выходе из функции удаляем последнюю цифру дабы дать рассмотреть другие варианты
    */
    public static int tryAllSubsets(List<Integer> current, int last, int[] S, int minProblems) {
        if (current.size() >= minProblems) return minProblems; // Prune - cut -  unnecessary checks
        int[] problemSet = current.stream().mapToInt(i -> i).toArray();
        if (canRepresentAll(problemSet, S)) {
            return Math.min(minProblems, problemSet.length);
        }
        for (int i = last; i <= 3; i++) {
            current.add(i);
            minProblems = tryAllSubsets(current, i, S, minProblems);
            current.remove(current.size() - 1);
        }
        return minProblems;
    }

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



}

