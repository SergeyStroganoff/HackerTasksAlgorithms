package algo.dinamic_programming.coin_exchange_dp;

import java.util.*;

public class MoneyExchangeBruteForce {
    public static Set<String> bunchOfResult = new HashSet<>();
    public static List<List<Integer>> accumulatorList = new ArrayList<>();

    public static void main(String[] args) {
        //TASK data
        int moneyAmount = 60;
        int[] nominalBuf = {5, 10, 25, 1};
        bruteForceIterationWithLimit2(moneyAmount, nominalBuf, 0, Collections.emptyList());
        System.out.println(accumulatorList.size());
        String minCountOfCoin = accumulatorList.stream().min((x, z) -> x.size() - z.size()).get().toString();
        System.out.println(minCountOfCoin);
        //accumulatorList.forEach(System.out::println);
    }

    private static void bruteForceIterationWithLimit2(int moneyAmount, int[] nominalBuf, int startIndex, List<Integer> currentCombination) {
        currentCombination = new ArrayList<>(currentCombination); // ветвим временные Листы c каждым ветвлением создавай новый Лист принимающий уже сформированную ветку
        //добавляем временный массив в массив аккумулятор только, если только moneyAmount == 0
        if (moneyAmount == 0) {
            accumulatorList.add(currentCombination);
        }
        for (int i = 0; i < nominalBuf.length; i++) { //если нужны не уникальные сочетания, а с повторениями, то i=0 иначе startIndex.
            int moneyLimitReduced = moneyAmount - nominalBuf[i]; // уменьшаем сумму денег на номинал buf[i]
            if (moneyLimitReduced < 0) {
                continue; // если денег стало < 0 - прекращаем текущий цикл и начинаем с нового индекса
            }
            currentCombination.add(nominalBuf[i]); // сохраняем временный элемент с нарастающим итогом
            bruteForceIterationWithLimit2(moneyLimitReduced, nominalBuf, startIndex + 1, currentCombination);
            currentCombination.remove(currentCombination.size() - 1); // удаляем последний элемент, что бы не было неразберихи
        }
    }
    // перебор всех вариантов в лоб с сохранением вариантов в List

    /*
    Перестановки: мы проходим по массиву рекурсивной функцией принимающей сам массив и начальный индекс
    Граничное условие -> если индекс = концу массива то собранием массив в Set и выходим
    иначе запускаем цикл в котором меняем поочередно символ с индексом старт на оставшиеся символы с индексом большим чем старт
    вызываем рекурсивную функции прибавляя индекс старт (смещая вправо)
    меняем символы обратно.
     */
    private static void allPermutations(int[] array, int startIndex) {
        if (startIndex == array.length - 1) {
            bunchOfResult.add(Arrays.toString(array));
            return;
        }
        for (int i = startIndex; i < array.length; i++) {
            swap(array, startIndex, i);
            allPermutations(array, startIndex + 1);
            swap(array, startIndex, i);
        }
    }

    private static void swap(int[] buf, int i, int k) {
        int temp = buf[i];
        buf[i] = buf[k];
        buf[k] = temp;
    }
}
