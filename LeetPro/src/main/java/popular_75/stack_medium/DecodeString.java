package popular_75.stack_medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces,
 * square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 */

public class DecodeString {

    public static void main(String[] args) {
        String testString = "3[a2[c]]";
        String testString2 = "3[a]2[bc]";
        String testString3 = "abc3[cd]xyz";
        String testString4 = "3[z]2[2[y]pq4[2[jk]e1[m]]]ef";
        //zzz yypqjkjkjkjkjkjkjkjkefyypqjkjkjkjkjkjkjkjkef ef   ef
        // System.out.println(testString);
        // System.out.print(decodeStringNew(testString));
        System.out.println(decodeStringIterative(testString4));
    }

    public static String decodeStringIterative(String s) {
        Deque<Integer> positionLeftBracket = new ArrayDeque<>();
        Deque<StringBuilder> strings = new ArrayDeque<>();
        Deque<Integer> multiplierStack = new ArrayDeque<>();
        strings.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            //прибавляем все символы во вне брекетов
            if (Character.isLetter(s.charAt(i))) {
                strings.peek().append(s.charAt(i));
            }
            if (s.charAt(i) == '[') {
                positionLeftBracket.push(i);
                multiplierStack.push(getMultiplier(s, i));
                strings.push(new StringBuilder());
            }
            if (s.charAt(i) == ']') {
                int leftPosition = positionLeftBracket.pop();
                int multiplier = multiplierStack.pop();
                String string;
                if (strings.peek().length() == 0) {
                    string = s.substring(leftPosition + 1, i);
                    string = string.repeat(multiplier);
                    string = strings.pop().append(string).toString();
                } else {
                    string = strings.pop().toString();
                    string = string.repeat(multiplier);
                }
                strings.peek().append(string);
            }
        }
        return strings.pop().toString();
    }
    private static Integer getMultiplier(String s, int position) {
        int leftPosition = position - 1;
        for (int i = position - 1; i >= 0; i--) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                leftPosition = i;
            } else {
                break;
            }
        }
        return Integer.parseInt(s.substring(leftPosition, position));
    }


    public static String decodeStringIterativeCGPT(String s) {
        Deque<StringBuilder> strings = new ArrayDeque<>();
        Deque<Integer> multiplierStack = new ArrayDeque<>();
        strings.push(new StringBuilder());
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                strings.peek().append(c);
            } else if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                multiplierStack.push(Integer.parseInt(s.substring(start, i)));
                continue; // Move to the next character without incrementing i again
            } else if (c == '[') {
                strings.push(new StringBuilder());
            } else if (c == ']') {
                int multiplier = multiplierStack.pop();
                String repeated = strings.pop().toString().repeat(multiplier);
                strings.peek().append(repeated);
            }
            i++;
        }
        return strings.pop().toString();
    }
}