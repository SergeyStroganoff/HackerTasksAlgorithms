package org.yandex_handbook.dp_rocks_game;

import java.util.Scanner;

public class RockGameSolution {

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
        memoryArray[1][0] = 2;
        memoryArray[1][1] = 2;

        for (int row = 0; row <= n; row++) {
            for (int column = 0; column <= m; column++) {
                if (memoryArray[row][column] == 0) {
                    byte left = 0;
                    byte up = 0;
                    byte diagonal = 0;
                    if (row - 1 >= 0) {
                        up = memoryArray[row - 1][column];
                    }
                    if (column - 1 >= 0) {
                        left = memoryArray[row][column - 1];
                    }
                    if (left != 0 && up != 0) {
                        diagonal = memoryArray[row - 1][column - 1];
                    }
                    if (left == 1 || up == 1 || diagonal == 1) {
                        memoryArray[row][column] = 2;
                    } else {
                        memoryArray[row][column] = 1;
                    }
                }
            }
        }
        return memoryArray[n][m] == 2 ? "Win" : "Loose";
    }

}
