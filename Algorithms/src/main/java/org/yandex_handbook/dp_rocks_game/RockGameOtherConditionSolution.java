package org.yandex_handbook.dp_rocks_game;
/**
 * Вы играете в игру <<Камни>>: игру для двух игроков с двумя наборами камней по n and m
 * . С каждым ходом один игрок может забрать следующие комбинации камней:
 * <p>
 * Взять один камень из любого набора.
 * Взять два камня из какого-то одного набора
 * Взять два камня из одного и один из другого.
 * Когда камень забрали, он выходит из игры. Побеждает игрок, который заберет последний камень. Первый ход за вами.
 */

import org.utils.MultidimensionalArrayUtil;

import java.util.Scanner;

public class RockGameOtherConditionSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(isFirstPlayerWinner(n, m));
    }


    public static String isFirstPlayerWinner(int n, int m) {
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Заполняем базовые случаи
        dp[0][0] = false; // Оба набора пусты, победитель не определен

        // Заполняем значения для одного пустого набора
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false; // Первый игрок не может взять камень из пустого набора
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false; // Первый игрок не может взять камень из пустого набора
        }

        // Заполняем оставшиеся значения используя рекуррентные соотношения
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean canWin = false;
                if (i - 1 >= 0 && !dp[i - 1][j]) {
                    canWin = true; // Можно взять один камень из первого набора
                }
                if (j - 1 >= 0 && !dp[i][j - 1]) {
                    canWin = true; // Можно взять один камень из второго набора
                }
                if (i - 2 >= 0 && !dp[i - 2][j]) {
                    canWin = true; // Можно взять два камня из первого набора
                }
                if (j - 2 >= 0 && !dp[i][j - 2]) {
                    canWin = true; // Можно взять два камня из второго набора
                }
                if (i - 1 >= 0 && j - 1 >= 0 && !dp[i - 1][j - 1]) {
                    canWin = true; // Можно взять два камня из одного набора и один из другого
                }
                dp[i][j] = canWin;
            }
        }


        MultidimensionalArrayUtil.print(dp);
        return dp[n][m] ? "Win" : "Loose";
    }
}
