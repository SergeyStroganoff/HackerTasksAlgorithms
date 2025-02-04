package algo.dinamic_programming.coin_exchange_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Создаем массив размером количества денег + 1 и заполняем любой суммой больше количества денег
 * первый индекс массива это ноль т.к. для нуля нужно ноль монет для размена.
 * Далее в цикле проходим по массиву и устанавливаем значение количества монет для каждой суммы от 1 до amount
 * перед установкой проверяем условие, что amount – coint >0
 * рекуррентная f = [i] = Min(buf[i], buf[i-coin] +1 т.е. на каждом шаге новое значение минимальному
 * из уже подобранных и записанных в этой клетке или из значения для суммы за минусом текущей монеты (это значение будет
 * уже в массиве по индексу amount-coin)
 * Для восстановления монет - инициализируем новый массив размером amount и каждый раз в существующем цикле
 * заносим туда оптимально выбранную монету ...
 * Восстанавливаем: начиная с последнего элемента каждый раз отнимаем от amount найденную монету до тех пока amount> 0;
 */

public class MoneyExchangeDP {
    public static void main(String[] args) {
        //TASK data
        int moneyAmount = 12;
        int[] coinsBuf = {5, 10, 25, 1};
        int[] memoryBuf = new int[moneyAmount + 1];
        String optimalExchangeCoinsCount = String.valueOf(getOptimalCoinCount(coinsBuf, moneyAmount, memoryBuf));
        System.out.println(optimalExchangeCoinsCount);
        System.out.println(getResultCoinSet(memoryBuf, moneyAmount));
    }

    private static List<Integer> getResultCoinSet(int[] memoryBuf, int moneyAmount) {
        if (moneyAmount == 0) {
            return Collections.emptyList();
        }
        List<Integer> resultList = new ArrayList<>();
        while (moneyAmount > 0) {
            int nextCoin = memoryBuf[moneyAmount];
            resultList.add(nextCoin);
            moneyAmount -= nextCoin;
        }
        return resultList;
    }


    public static int getOptimalCoinCount(int[] coinsBuf, int moneyAmount, int[] memoryBuf) {
        int[] dp = new int[moneyAmount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // base condition
        dp[0] = 0;
        // iterate all amount options and fill array
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coinsBuf) {
                if (i - coin >= 0) {
                    int searchingIndex = i - coin;
                    dp[i] = Math.min(dp[i], dp[searchingIndex] + 1);
                    if (dp[i] == dp[searchingIndex] + 1) {
                        memoryBuf[i] = coin;
                    }
                }
            }
        }
        return dp[moneyAmount];
    }
}
