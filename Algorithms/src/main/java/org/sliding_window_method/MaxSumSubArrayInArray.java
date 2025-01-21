package org.sliding_window_method;

/**
 * Максимальная сумма подмассива фиксированного размера
 * Задача: Найти максимальную сумму подмассива длины 𝑘
 */
public class MaxSumSubArrayInArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7, 2, 4, 1};
        int k = 3;
        System.out.println("Максимальная сумма под массива длины " + k + ": " + maxSumImproved(nums, k)); // Вывод: 14
    }


    /**
     * Solution O(n_2)
     */
    private static String maxSum(int[] nums, int k) {
        if (nums.length == 0) {
            return String.valueOf(0);
        }
        if (nums.length == 1) {
            return String.valueOf(1);
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1 - k; i++) {
            int localSum = 0;
            for (int n = 0; n < k; n++) {
                localSum += nums[i + n];
            }
            max = Math.max(localSum, max);
        }
        return String.valueOf(max);
    }


    /**
     * Solution O(n)
     */
    public static int maxSumImproved(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;
        // Сначала вычисляем сумму первого окна - инициализировали окно
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        // Двигаем окно вправо
        for (int i = k; i < nums.length; i++) {
            // Прибавляем значение числа вошедшее в окно справа
            // и вычитаем из суммы число слева, которое вышло из зоны окна
            // таким образом не пересчитываем всю сумму, а делаем только два арифметических действия
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
