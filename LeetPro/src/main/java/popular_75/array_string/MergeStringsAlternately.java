package popular_75.array_string;

/**
 * You are given two strings word1 and word2.
 * Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other,
 * append the additional letters onto the end of the merged string.
 * Return the merged string.
 */
public class MergeStringsAlternately {

    public static void main(String[] args) {
        String word1 = "1234";
        String word2 = "abcdfgi";
        System.out.print(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            result.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }
        if (word1.length() > i) {
            result.append(word1.substring(i));
        } else if (word2.length() > i) {
            result.append(word2.substring(i));
        }
        return result.toString();
    }
}
