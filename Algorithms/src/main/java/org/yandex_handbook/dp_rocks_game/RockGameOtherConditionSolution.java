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
        System.out.println(checkIfFirstIsWinner(n, m));
    }

    private static String checkIfFirstIsWinner(int n, int m) {

        byte[][] memoryArray = new byte[n + 1][m + 1];
        memoryArray[0][0] = 1;
        memoryArray[0][1] = 2;
        memoryArray[0][2] = 2;
        memoryArray[1][0] = 2;
        memoryArray[2][0] = 2;
        memoryArray[1][1] = 2;
        memoryArray[1][2] = 1;
        memoryArray[2][1] = 1;
        memoryArray[2][2] = 1;

        for (int row = 0; row <= n; row++) {
            for (int column = 0; column <= m; column++) {
                if (memoryArray[row][column] == 0) {
                    byte left = 0;
                    byte up = 0;
                    byte diagonal = 0;
                    byte leftOnTwo = 0;
                    byte upOnTwo = 0;

                    if (row - 1 >= 0) {
                        up = memoryArray[row - 1][column];
                    }
                    if (column - 1 >= 0) {
                        left = memoryArray[row][column - 1];
                    }
                    if (row - 2 >= 0) {
                        upOnTwo = memoryArray[row - 2][column];
                    }
                    if (column - 2 >= 0) {
                        leftOnTwo = memoryArray[row][column - 2];
                    }

                    if (left != 0 && up != 0) {
                        diagonal = memoryArray[row - 1][column - 1];
                    }
                    if (left == 1 || up == 1 || diagonal == 1 || upOnTwo == 1 || leftOnTwo == 1) {
                        memoryArray[row][column] = 2;
                    } else {
                        memoryArray[row][column] = 1;
                    }
                }
            }
        }
        MultidimensionalArrayUtil.print(memoryArray);
        return memoryArray[n][m] == 2 ? "Win" : "Loose";
    }
}
