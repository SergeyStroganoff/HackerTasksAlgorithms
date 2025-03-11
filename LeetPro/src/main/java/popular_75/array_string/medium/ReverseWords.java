package popular_75.array_string.medium;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */

public class ReverseWords {

    public static void main(String[] args) {
        String test = " hello  world  ";
        System.out.println(reverseWords(test));
    }

    public static String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringBuf = s.split("\\s+");

        for (int i = stringBuf.length - 1; i >= 0; i--) {
            if (!stringBuf[i].equals("")) {
                stringBuilder.append(stringBuf[i]).append(" ");
            }

        }
        return stringBuilder.toString().trim();
    }
}
