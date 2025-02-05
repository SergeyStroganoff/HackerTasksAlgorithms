package com.stroganow.easy;

import java.util.Arrays;

/**
 * Напечатать однобокую елку или лестницу
 * #
 * ##
 * ###
 * ####
 */

public class OneSideStair {

    public static void main(String[] args) {
        int n = 4;
        printStair(n);
    }

    private static void printStair(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] nextString = new char[n];
        Arrays.fill(nextString, ' ');
        for (int i = n - 1; i >= 0; i--) {
            nextString[i] = '#';
            stringBuilder.append(nextString).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
