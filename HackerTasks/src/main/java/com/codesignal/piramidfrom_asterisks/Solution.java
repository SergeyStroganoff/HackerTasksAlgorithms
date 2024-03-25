package com.codesignal.piramidfrom_asterisks;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(printPyramid(5));
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
}
