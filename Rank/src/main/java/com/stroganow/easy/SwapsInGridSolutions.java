package com.stroganow.easy;

import java.util.Arrays;
import java.util.List;

/**
 * У вас есть таблица размера N , состоящая из букв. Вы можете применить следующую операцию несколько раз: поменять местами два соседних символа в любой строке.
 * Можно ли, применяя данную операцию, добиться выполнения следующего условия? Все буквы меньше слева на право и верхня строка лексографически меньше нижней
 * Т.е. Сравнить лексографически строки.
 */
public class SwapsInGridSolutions {
    public static void main(String[] args) {
        List<String> testCase = List.of("mpxz", "abcd", "wlmf");
        System.out.println(checkIfGridCanBeNormalizedInOrderOfAlphabet(testCase));
    }

    public static String checkIfGridCanBeNormalizedInOrderOfAlphabet(List<String> grid) {
        if (grid.isEmpty()) {
            return "NO";
        }
        char[] temp = null;
        for (String s : grid) {
            char[] charBuf = s.toCharArray();
            Arrays.sort(charBuf);
            if (temp == null) {
                temp = charBuf;
            }
            for (int j = 0; j < charBuf.length; j++) {
                if (charBuf[j] < temp[j]) {
                    return "NO";
                }
            }
            temp = charBuf;
        }
        return "YES";
    }
}
