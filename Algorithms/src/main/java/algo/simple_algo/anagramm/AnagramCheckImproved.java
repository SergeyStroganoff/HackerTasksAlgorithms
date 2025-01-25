package algo.simple_algo.anagramm;

import java.util.HashMap;
import java.util.Map;

/**
 * Anagram check - "abc" and "bac" are anagrams
 */
public class AnagramCheckImproved {

    /**
     * Method for ASCII
     *
     * @param s1 String
     * @param s2 String
     * @return boolean
     */

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] charCountsBuf = new int[256]; // If ASCII
        for (char c : s1.toCharArray()) {
            charCountsBuf[c]++;
        }
        for (char c : s2.toCharArray()) {
            charCountsBuf[c]--;
            if (charCountsBuf[c] < 0) {
                return false;
            }
        }
        return true; // Если все символы совпадают
    }

    /**
     * Method for Unicode
     *
     * @param s1 String
     * @param s2 String
     * @return boolean
     */

    public static boolean areAnagramsUnicode(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        // Use a map to handle any Unicode character
        Map<Character, Integer> charCounts = new HashMap<>();

        // Count characters in the first string
        for (char c : s1.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Subtract counts for characters in the second string
        for (char c : s2.toCharArray()) {
            if (!charCounts.containsKey(c)) {
                return false; // Character not found in the first string
            }
            charCounts.put(c, charCounts.get(c) - 1);
            if (charCounts.get(c) == 0) {
                charCounts.remove(c); // Remove zero entries to save space
            }
        }

        // If the map is empty, the strings are anagrams
        return charCounts.isEmpty();
    }

}
