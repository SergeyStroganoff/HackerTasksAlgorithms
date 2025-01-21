package org.simple_algo.palindrome;

import java.util.ArrayDeque;

public class PalindromeUtil {

    public static boolean isPalindromeStringBuilder(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder(word);
        String reverseWord = stringBuilder.reverse().toString();
        return word.equals(reverseWord);
    }

    public static boolean isPalindromeStack(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }

        char[] wordArray = word.toCharArray();
        int middle = wordArray.length / 2;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i <= middle; i++) {
            stack.push(wordArray[i]);
        }
        for (int i = middle; i < wordArray.length; i++) {
            if (wordArray[i] != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
