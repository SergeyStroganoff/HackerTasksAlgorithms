package com.fb;

import java.util.Arrays;


/**
 * Необходимо найти минимальное значение задач с оценками 1,2,3
 * Из которых можно составить сет суммарных значений оценок
 * для каждого участника набранных решением данных задач данных в массиве
 * <p>
 * Решение:
 * Находим участника с максимальной суммой балов
 * Проверяем - есть ли участник набравший только один бал
 * Вычисляем - значение троек необходимое для составления наибольшей суммы балов максимально успешного участника
 * <p>
 * Если максимальное значение очков делиться на 3 без остатка, но в сете есть значения которые делятся с остатком 2 и 1
 * то возвращаем ответ maxScore / 3 и прибавляем еще одну задачу т.к. мы используем тройки во всех случаях и двойку или единицу
 * которые по факту дают еще одну задачу (1+3)
 * Далее проверяем: если в наборе нет единицы, то
 */
public class ScoreboardInferenceLevel2 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(getMinProblemCount(6, test));
    }

    public static int getMinProblemCount(int N, int[] S) {

        // сохраняем признаки наличия модулей от деления на 3
        boolean[] mods3 = new boolean[3];
        boolean hasOne = Arrays.stream(S).anyMatch(x -> x == 1);
        int maxScore = Arrays.stream(S).max().orElse(0);
        int maxScoreMultiple3 = 0;

        //выбираем максимальное значение которое делиться на 3 без остатка
        for (int score : S) {
            if (score % 3 == 0) {
                maxScoreMultiple3 = Math.max(maxScoreMultiple3, score);
            }
            mods3[score % 3] = true;
        }
        if (maxScore % 3 == 0 && mods3[1] && mods3[2]) {
            return maxScore / 3 + 1;
        }
        //  - если нет единицы есть остатки 1 и 2 и целая часть максимальной оценки (от деления на три)
        //максимальному числу делящемуся на 3 без остатка
        //
        if (!hasOne && mods3[1] && mods3[2] && maxScoreMultiple3 != 3 * (maxScore / 3)) {
            return maxScore / 3 + 2 - (maxScore % 3 == 1 ? 1 : 0);
        }

        return maxScore / 3 + (mods3[1] ? 1 : 0) + (mods3[2] ? 1 : 0);
    }
}
