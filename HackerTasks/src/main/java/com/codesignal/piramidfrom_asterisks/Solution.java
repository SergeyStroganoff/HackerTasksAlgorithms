package com.codesignal.piramidfrom_asterisks;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(piramidVersion3(5));
    }

    public static String printPyramid(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int asterisks = n * 2 - 1;
        char[] chars = new char[asterisks];
        Arrays.fill(chars, ' ');
        for (int i = 0; i < n; i++) { // rows
            for (int j = 0; j < 1 + i * 2; j++) { // spaces
                chars[asterisks / 2 + j - i] = '*';
            }
            stringBuilder.append(chars).append("\n");
        }
        return stringBuilder.toString();

    }


    public static String[] pyramidFromAsterisks(int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = " ".repeat(n - i - 1) + "*".repeat(2 * i + 1) + " ".repeat(n - i - 1);
        }
        return result;
    }

    public static String piramidVersion3(int n) {
        int maxWidth = n * 2 - 1;
        int middleIndex = maxWidth / 2;
        int l = middleIndex;
        int r = middleIndex;
        StringBuilder pyramid = new StringBuilder();
        char[] row = new char[maxWidth];
        Arrays.fill(row, ' ');
        for (int i = 0; i < n; i++) {
            for (int d = l; d <= r; d++) {
                row[d] = '*';
                //System.out.println(d);
            }
            pyramid.append(row).append("\n");
            Arrays.fill(row, ' ');
            l--;
            r++;
        }
        return pyramid.toString();
    }
}
