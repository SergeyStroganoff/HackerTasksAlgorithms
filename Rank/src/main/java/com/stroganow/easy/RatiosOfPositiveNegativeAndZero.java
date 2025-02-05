package com.stroganow.easy;

import java.util.List;

public class RatiosOfPositiveNegativeAndZero {
    /**
     * Данн массив чисел Int. Надо найти рейтинг (соотношение позитивных, негативны и гулей к общему числу
     * и вывести соотношение
     */

    public static void main(String[] args) {
        printRatio(List.of(1, 3, 5, -4, 5, -5, 0, 0));
    }

    public static void printRatio(List<Integer> arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        int numberCount = arr.size();

        for (Integer nextValue : arr) {
            if (nextValue > 0) {
                positive++;
            } else if (nextValue == 0) {
                zero++;
            } else {
                negative++;
            }
        }
        double positiveRation = (double) positive / numberCount;
        double negativeRation = (double) negative / numberCount;
        double zeroRation = (double) zero / numberCount;

        System.out.println(positiveRation);
        System.out.println(negativeRation);
        System.out.println(zeroRation);
    }
}
