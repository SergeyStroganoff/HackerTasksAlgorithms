package algo.simple_algo.palindrome;

public class PalindromeEffective {
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

    /**
     * the most effective method
     *
     * @param word
     * @return
     */

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
}
