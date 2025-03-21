package algo.simple_algo.anagramm;

import java.util.Arrays;


/**
 * Anagram check - "abc" and "bac" are anagrams
 * Если строки null или не равны по длине -> false
 * Переводим строки в массивы char, сортируем и затем сравниваем Array,equals.
 */

public class AnagramCheck {

    /**
     * @param strOne
     * @param strTwo
     * @return
     */
    public static boolean isAnagrams(String strOne, String strTwo) {
        if (strOne == null || strTwo == null || strOne.length() != strTwo.length()) {
            return false;
        }
        char[] stringOneCharArray = strOne.toCharArray();
        char[] stringTwoCharArray = strOne.toCharArray();
        Arrays.sort(stringOneCharArray);
        Arrays.sort(stringTwoCharArray);
        return Arrays.equals(stringOneCharArray, stringTwoCharArray);
    }


}
