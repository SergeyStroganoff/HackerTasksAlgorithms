package org.sliding_window_method;

import java.util.HashMap;

/**
 * Пример 2: Наибольшая подстрока с уникальными символами
 * Задача: Найти длину самой длинной подстроки, содержащей только уникальные символы.
 */

public class LongestSubStringWithUniqueChars {
    public static void main(String[] args) {
        LongestSubStringWithUniqueChars thisClassInstance = new LongestSubStringWithUniqueChars();

        String s = "abcscsccccc";
        System.out.println("Длина самой длинной подстроки с уникальными символами: " + thisClassInstance.lengthOfLongestSubstring(s)); // Вывод: 3
    }

    public String lengthOfLongestSubstring(String s) {
        // обработка крайних состояний
        if (s == null || s.isEmpty()) {
            return "0"; // Handle empty string
        }
        if (s.length() == 1) {
            return "" + 1;
        }
        int maxSubStringLength = 1;
        int i = 1;
        int k = 0;
        char[] stringCharBuf = s.toCharArray();
        // идем по символам строки
        HashMap<Character, Integer> window = new HashMap<>();
        window.put(stringCharBuf[k], k);
        while (i < stringCharBuf.length) {
            if (window.containsKey(stringCharBuf[i]) && window.get(stringCharBuf[i]) >= k) {
                k = window.get(stringCharBuf[i]) + 1;
            }
            window.put(stringCharBuf[i], i);
            maxSubStringLength = Math.max(maxSubStringLength, i - k);
            i++;
        }
        return String.valueOf(maxSubStringLength);
    }
}
