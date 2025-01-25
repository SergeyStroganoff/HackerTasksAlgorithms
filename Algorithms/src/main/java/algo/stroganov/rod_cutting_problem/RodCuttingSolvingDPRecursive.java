package algo.stroganov.rod_cutting_problem;

import java.util.Arrays;

public class RodCuttingSolvingDPRecursive {

    // Метод возвращает максимальную цену для разрезания палки длиной n метров
    //низходящий рекурсивный подход

    public int cutRodDownAproach(int[] price, int n) {
        // System.out.println("Заходим в рекурсивный вызов cutRodDownAproach с параметрами: price = " + price + "; n = " + n);
        if (n <= 0) {
            System.out.println("Базовый случай - Возвращаемое значение: " + 0);
            return 0;
        }
        int maxVal = Integer.MIN_VALUE; // Максимальная цена для разрезания палки длиной n метров
        int lastPartPrice;
        // Перебираем все варианты разрезания
        for (int i = 1; i <= n; i++) {
            // можно добавить мемоизацию - сохранять результаты и затем исскать их в кэше !!!
            System.out.println("Вызов cutRodDownAproach с параметрами: price = " + Arrays.toString(price) + "; n = " + (n - i));
                    lastPartPrice = cutRodDownAproach(price, n - i);
            maxVal = Math.max(maxVal, price[i] + lastPartPrice);
        }
        System.out.println("Выходим из рекурсивного вызова- Возвращаемое значение: " + maxVal);
        return maxVal;
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
