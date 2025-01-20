package org.simple_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static void main(String[] args) {
        System.out.println(isAnagrams("123", "234"));
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
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
