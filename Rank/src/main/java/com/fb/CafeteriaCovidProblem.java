package com.fb;

import java.util.Arrays;

/**
 * A cafeteria table consists of a row of * N seats, numbered from
 * 1 to N from left to right.
 * Social distancing guidelines require that every diner be seated such that
 * K seats to their left and K seats to their right
 * (or all the remaining seats to that side if there are fewer than K) remain empty.
 * There are currently M diners seated at the table, thei ith of whom is in seat Si
 * No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
 * Determine the maximum number of additional diners
 * who can potentially sit at the table without social distancing guidelines
 * being violated for any new or existing diners,
 * assuming that the existing diners cannot move and that the additional diners
 * will cooperate to maximize how many of them can sit down;
 * <p>
 * Example: N = 10
 * K = 1
 * M = 2
 * S = [2, 6]
 * Return 3
 * <p>
 * <p>
 * In the first case, the cafeteria table has
 * N=10 seats, with two diners currently at seats
 * 2 and 6 respectively. The table initially looks as follows, with brackets covering the
 * K=1 seat to the left and right of each existing diner that may not be taken.
 * 1 2 3 4 5 6 7 8 9 10
 * [   ]   [   ]
 * Three additional diners may sit at seats 4, 8, and 110 without violating the social distancing guidelines.
 * <p>
 * Решение: му будем помечать элементы массива как занятые (черные), как смежные (серые) и как вакантные (белые)
 * Ответ: количество белых.
 * <p>
 * логика: если место не занято и не серое то сажаем - сажаем и увеличиваем счетчик
 */


public class CafeteriaCovidProblem {
    public static void main(String[] args) {
        long[] cafe = {2, 6};
        System.out.println(getMaxAdditionalDinersCount2(10, 1, 2, cafe));
    }

    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
        long person = 0;
        long start = 1;
        for (int i = 0; i < S.length; i++) {
            while (start < S[i] - K) {
                System.out.println("Посадили на место:" + start);
                person++;
                start += K + 1;
            }
            start = S[i] + K + 1;
        }
        while (start < N + 1) {
            System.out.println("Посадили на место:" + start);
            person++;
            start += K + 1;
        }

        return person;
    }

    public static long getMaxAdditionalDinersCount2(long N, long K, int M, long[] S) {
        Arrays.sort(S); // Sort the array of seated diners
        long additionalDiners = 0;

        // Calculate the number of additional diners before the first seated diner
        long firstSeat = S[0];
        long availableSeats = firstSeat - 1; // Seats before the first diner
        additionalDiners += Math.max(0, (availableSeats) / (K + 1));

        // Calculate the number of additional diners between seated diners
        for (int i = 1; i < M; i++) {
            long prevSeat = S[i - 1];
            long currentSeat = S[i];
            long gap = currentSeat - prevSeat - 1; // Seats between two diners
            additionalDiners += Math.max(0, (gap - K) / (K + 1));
        }

        // Calculate the number of additional diners after the last seated diner
        long lastSeat = S[M - 1];
        availableSeats = N - lastSeat; // Seats after the last diner
        additionalDiners += Math.max(0, availableSeats / (K + 1));
        return additionalDiners;
    }
}
