package org.yandex_handbook.dp_rocks_game;

import org.utils.MultidimensionalArrayUtil;

import java.util.Scanner;

public class RockGameSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(checkIfFirstIsWinner(n, m));

    }

    private static String checkIfFirstIsWinner(int n, int m) {
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                boolean winStatus = false;
                if (i == 0 && j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (i > 0 && !dp[i - 1][j]) { // берем один камень с ряда
                    winStatus = true;
                }
                if (j > 0 && !dp[i][j - 1]) { // берем один камень со второго ряда
                    winStatus = true;
                }

                if (i > 0 && j > 0 && !dp[i - 1][j - 1]) { // берем два камня - по камню с ряда
                    winStatus = true;
                }
                dp[i][j] = winStatus;
            }

        }
        MultidimensionalArrayUtil.print(dp);
        return dp[n][m] ? "Win" : "Lose";
    }
    }

