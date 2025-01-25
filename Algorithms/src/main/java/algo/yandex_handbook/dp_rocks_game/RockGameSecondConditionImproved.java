package algo.yandex_handbook.dp_rocks_game;

import algo.utils.MultidimensionalArrayUtil;

import java.util.Scanner;

/**
 * Вы играете в игру <<Камни>>: игру для двух игроков с двумя наборами камней по n and m
 * . С каждым ходом один игрок может забрать следующие комбинации камней:
 * <p>
 * Взять один камень из любого набора.
 * Взять два камня из какого-то одного набора
 * Взять два камня из одного и один из другого.
 * Когда камень забрали, он выходит из игры. Побеждает игрок, который заберет последний камень. Первый ход за вами.
 * В первой строке содержится два числа n и m (1 ≤ n, m ≤ 10000) — количество камней в первом и втором наборе соответственно.
 * <p>
 * Решение:
 * Базовые случаи:
 * - Если обе кучи пусты (i = 0 и j = 0), то это проигрышная позиция для текущего игрока,
 * так как ходить больше нельзя.
 * <p>
 * Заполнение таблицы:
 * <p>
 * Для каждой позиции (i, j) определяем её статус на основе возможных ходов:
 * <p>
 * Взять один камень из любой кучи: переход к состояниям (i-1, j) или (i, j-1).
 * Взять два камня из одной кучи: переход к состояниям (i-2, j) или (i, j-2).
 * Взять два камня из одной и один из другой: переход к состояниям (i-2, j-1) или (i-1, j-2).
 * Позиция (i, j) считается выигрышной (true), если существует хотя бы один ход (Оптимальный ход), приводящий к проигрышной позиции соперника.
 * Иначе она считается проигрышной (false).
 */

public class RockGameSecondConditionImproved {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(isFirstPlayerWinner(n, m));
    }


    public static String isFirstPlayerWinner(int n, int m) {
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                boolean winStatus = false;
                if (i == 0 && j == 0) {
                    dp[i][j] = winStatus;
                    continue;
                }
                if (i > 0 && !dp[i - 1][j]) {
                    winStatus = true;
                }
                if (j > 0 && !dp[i][j - 1]) {
                    winStatus = true;
                }

                if (i > 1 && !dp[i - 2][j]) {
                    winStatus = true;
                }
                if (j > 1 && !dp[i][j - 2]) {
                    winStatus = true;
                }

                if (i > 1 && j > 0 && !dp[i - 2][j - 1]) {
                    winStatus = true;
                }
                if (j > 1 && i > 0 && !dp[i - 1][j - 2]) {
                    winStatus = true;
                }
                dp[i][j] = winStatus;
            }

        }
        MultidimensionalArrayUtil.print(dp);
        return dp[n][m] ? "Win" : "Lose";
    }
}
