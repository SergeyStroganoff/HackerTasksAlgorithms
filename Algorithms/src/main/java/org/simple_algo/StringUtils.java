package org.simple_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static void main(String[] args) {
        System.out.println(isAnagrams("123", "234"));
    }


    /**
     * Проверка палиндрома  число, буквосочетание, слово или текст, одинаково читающееся в обоих направлениях. Например, число 101; слова «топот» в русском языке
     * А роза упала на лапу Азора
     *
     * @param str
     * @return
     */

    public static boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
    }

    public static boolean isPalindromeByIteration(String word) {
        if (word == null || word.length() <= 1) {
            return true; // Handles null, empty strings, and single-character strings
        }
        if (word.length() == 1) {
            return true;
        }
        char[] charBufWord = word.toCharArray();
        int i = 0;
        while (i < charBufWord.length) {
            char temp = charBufWord[i];
            charBufWord[i] = charBufWord[charBufWord.length - 1 - i];
            charBufWord[charBufWord.length - 1 - i] = temp;
            i++;
        }
        String reversedWord = String.valueOf(charBufWord);
        return reversedWord.equals(word);
    }

    public static boolean isPalindromeByIterationImproved(String word) {
        if (word == null || word.length() <= 1) {
            return true; // Handles null, empty strings, and single-character strings
        }
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false; // Characters don't match; not a palindrome
            }
            left++;
            right--;
        }
        return true; // All characters match; it is a palindrome
    }


    public static boolean isEquals(String str1, String str2) {
        return str1.compareTo(str2) == 0;
    }

    static List<String> getAllPermutation(String str) {
        List<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                list.add(String.valueOf(chars));
            }
        }
        return list;
    }

    public static boolean isEqualsByLink(String str1, String str2) {
        return str1 == str2;
    }


    //anagrams
    public static boolean isAnagrams(String strOne, String strTwo) {
        if (strOne.length() != strTwo.length()) {
            return false;
        }
        char[] stringOneCharArray = strOne.toCharArray();
        char[] stringTwoCharArray = strOne.toCharArray();
        Arrays.sort(stringOneCharArray);
        Arrays.sort(stringTwoCharArray);
        return Arrays.equals(stringOneCharArray, stringTwoCharArray);
    }
}
