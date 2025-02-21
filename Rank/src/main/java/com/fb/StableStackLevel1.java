package com.fb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

/**
 * Задание: имеется стек поддонов вес которых указан в массиве
 * Стек является стабильным если поддоны лежат друг на друге в порядке
 * уменьшения веса. Что бы стабилизировать стек можно выполнить операцию уменьшения веса поддона (отпилить кусок)
 * Если выстроить правильный стек не получается то необходимо вернуть -1
 * Найти минимальное количество операций уменьшения веса поддонов.
 */

public class StableStackLevel1 {

    public static void main(String[] args) {
        int[] test = {2, 5, 3, 6, 5};
        System.out.println(getMinimumDeflatedDiscCountRight(0, test));
    }

    public static int getMinimumDeflatedDiscCountRight(int N, int[] R) {
        //Border case
        if (R.length == 1) {
            return 0;
        }
        if (R[R.length - 1] < R.length) {
            return -1;
        }
        int count = 0;
        for (int i = R.length - 1; i > 0; i--) {
            if (R[i - 1] >= R[i]) {
                R[i - 1] = R[i] - 1;
                if (R[i - 1] == 0) {
                    return -1;
                }
                count++;
            }

        }
        return count;
    }


    public static int getMinimumDeflatedDiscCountWrong(int N, int[] R) {
        //Border case
        if (R.length == 1) {
            return 0;
        }
        Set<Integer> indexListLongestSubsequence = getTheLongestSubsequence(R);
        HashSet<Integer> visited = new HashSet<>(indexListLongestSubsequence);
        int allChanges = 0;
        int cycleChanges = 1;
        while (cycleChanges != 0) {
            cycleChanges = 0;
            for (int nextIndex : indexListLongestSubsequence) {
                if (nextIndex + 1 < R.length && !visited.contains(nextIndex + 1)) {
                    if (R[nextIndex + 1] <= R[nextIndex]) {
                        R[nextIndex + 1] = R[nextIndex] + 1;
                        cycleChanges++;
                    }
                }
                if (nextIndex - 1 >= 0 && !visited.contains(nextIndex - 1)) {
                    if (R[nextIndex - 1] >= R[nextIndex]) {
                        R[nextIndex - 1] = R[nextIndex] - 1;
                        cycleChanges++;
                    }
                }
                visited.add(nextIndex + 1);
                visited.add(nextIndex - 1);
            }
            allChanges += cycleChanges;
        }
        return allChanges;
    }

    public static Set<Integer> getTheLongestSubsequence(int[] R) {
        HashSet<Integer> longestSubsequenceIndexArray = new HashSet<>();
        int[] dp = new int[R.length];
        int[] memory = new int[R.length];
        Arrays.fill(memory, -1);
        Arrays.fill(dp, 1);
        for (int i = 1; i < R.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (R[i] > R[j] && dp[j] + 1 > dp[i]) {
                    memory[i] = j;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        OptionalInt max = Arrays.stream(dp).max();
        System.out.println(max.getAsInt());
        System.out.println(Arrays.toString(memory));
        int indexOfLastLongestSubsequence = Arrays.binarySearch(dp, max.getAsInt());
        while (indexOfLastLongestSubsequence != -1) {
            longestSubsequenceIndexArray.add(indexOfLastLongestSubsequence);
            indexOfLastLongestSubsequence = memory[indexOfLastLongestSubsequence];
        }
        return longestSubsequenceIndexArray;
    }
}
