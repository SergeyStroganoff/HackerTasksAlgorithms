package org.utils;

public class MultidimensionalArrayUtil {

    public static  void print(byte[][] array) {
        for (byte[] row : array) {
            for (byte element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
