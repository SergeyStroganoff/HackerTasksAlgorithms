package org.stroganov.rod_cutting_problem;

public class RodCuttingSolvingDPRecursive {

    // Метод возвращает максимальную цену для разрезания палки длиной n метров
    //низходящий рекурсивный подход

    public int cutRodDownAproach(int[] price, int n) {
        if (n <= 0) {
            return 0;
        }
        int max_val = Integer.MIN_VALUE; // Максимальная цена для разрезания палки длиной n метров
        int lastPartPrice = 0;

        // Перебираем все варианты разрезания
        for (int i = 1; i <= n; i++) {
            // можно добавить мемоизацию - сохранять результаты и затем исскать их в кэше !!!
            lastPartPrice = cutRodDownAproach(price, n - i);
            max_val = Math.max(max_val, price[i] + lastPartPrice);
        }
        return max_val;
    }


    public int cutRodUpRecursiveApproach(int[] price, int n) {
        if (n == 1) {
            return price[1];
        }
        int[] maxProfitBuf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int maxProfit = Integer.MIN_VALUE; // Максимальная цена для разрезания палки длиной i метров
            for (int j = 1; j <= i; j++) { // Перебираем все варианты разрезания
                maxProfit = Math.max(maxProfit, price[j] + maxProfitBuf[i - j]);
                maxProfitBuf[i] = maxProfit;
            }
        }
        return maxProfitBuf[n];
    }
}
