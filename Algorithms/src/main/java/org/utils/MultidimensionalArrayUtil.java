package org.utils;

public class MultidimensionalArrayUtil {

    public static void print(boolean[][] array) {
        for (boolean[] row : array) {
            for (boolean element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
