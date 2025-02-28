package com.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Задание: имеется стек поддонов вес которых указан в массиве
 * Стек является стабильным если поддоны лежат друг на друге в порядке
 * уменьшения веса. Что бы стабилизировать стек можно выполнить операцию:
 * <p>
 * Inflate the disc, increasing its radius by 1 inch. This operation takes
 * A seconds and may be performed on discs of any radius (even those that exceed 10 9 inches).
 * Deflate the disc, decreasing its radius by1 inch.
 * This operation takes B seconds and may only be performed if the resulting radius is a positive
 * integer number of inches (that is, if the disc has a radius of at least 2" before being deflated).
 * Determine the minimum number of seconds needed in order to make the stack stable.
 * <p>
 * Найти минимальное количество операций уменьшения веса поддонов.
 */

public class StableStackLevel2Solution {

    public static void main(String[] args) {
        int[] test1 = {2, 5, 3, 6, 5};
        int[] test2 = {4, 2, 7, 3};
        int[] test3 = {6, 5, 4, 3};
        int[] test4 = {100, 100, 1, 1};
        int[] test5 = {6, 50, 2, 4, 4, 7};
        int[] test6 = {6, 500, 2, 300, 2, 250};
        int[] test7 = {50, 50, 3, 4, 5, 6, 7, 8};
        System.out.println(getMinimumSecondsRequired(6, test6, 1, 1));
        System.out.println(getMinimumSecondsRequired(4, test4, 5, 1));
        System.out.println(getMinimumSecondsRequired(5, test1, 1, 1));
    }


    public static long getMinimumSecondsRequired(int N, int[] R, int A, int B) {
        // Получаем все возможные радиусы
        List<Integer> radiusArr = getAllMeaningfulRadius(N, R);
        int radiusArrSize = radiusArr.size();
        // Массив минимальной стоимости
        long[] firstRawMinCostArrDP = new long[radiusArrSize];
        Arrays.fill(firstRawMinCostArrDP, Long.MAX_VALUE);

        // Заполняем первый ряд: обработка первого элемента
        //высчитываем разницу между реальным и потенциальным элементом и заносим в массив
        for (int i = 0; i < radiusArrSize; i++) {
            long diff = radiusArr.get(i) - R[0];
            firstRawMinCostArrDP[i] = diff >= 0 ? A * diff : B * -diff;
        }
        System.out.println(Arrays.toString(firstRawMinCostArrDP));
        // Основной цикл обработки оставшихся колец
        for (int i = 1; i < N; i++) {
            long[] secondRaw = new long[radiusArrSize];
            Arrays.fill(secondRaw, Long.MAX_VALUE);
            long previousBestScore = Long.MAX_VALUE;
            for (int col = i; col < radiusArrSize; col++) {
                long diff = radiusArr.get(col) - R[i];
                secondRaw[col] = diff >= 0 ? A * diff : B * -diff;
                // Находим минимум среди предыдущих значений
                previousBestScore = Math.min(previousBestScore, firstRawMinCostArrDP[col - 1]);
                // Прибавляем минимальную стоимость из предыдущей строки
                secondRaw[col] += previousBestScore;
            }
            // Обновляем массив минимальных затрат
            firstRawMinCostArrDP = secondRaw;
            System.out.println(Arrays.toString(firstRawMinCostArrDP));
        }
        // Находим минимальную стоимость среди всех финальных значений
        long ans = Long.MAX_VALUE;
        for (int col = N - 1; col < radiusArrSize; col++) {
            ans = Math.min(ans, firstRawMinCostArrDP[col]);
        }
        return ans;
    }

    public static List<Integer> getAllMeaningfulRadius(int N, int[] R) {
        // Используем TreeSet для сортировки без дубликатов
        TreeSet<Integer> radiusSet = new TreeSet<>();
        // Заполняем множество всеми возможными радиусами
        for (int i = 0; i < N; i++) {
            for (int ring = 0; ring < N; ring++) {
                radiusSet.add(R[i] + ring);
                if (R[i] - ring > 0) {
                    radiusSet.add(R[i] - ring);
                }
            }
        }
        // logging
        System.out.println(radiusSet);
        // Преобразуем множество в отсортированный список
        return new ArrayList<>(radiusSet);
    }

}
