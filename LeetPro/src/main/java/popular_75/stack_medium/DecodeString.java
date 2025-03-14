package popular_75.stack_medium;

import java.util.Stack;

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
        System.out.print(decodeString(testString));
    }

    public static String decodeString(String s) {
        StringBuilder resultString = new StringBuilder();
        Stack<Integer> stackDigital = new Stack<>();
        Stack<String> stackLString = new Stack<>();

        int leftIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                String numberString = s.substring(leftIndex, i);
                int value = Integer.parseInt(numberString);
                stackDigital.push(value);
                int rightIndex = 1;
                while (i + rightIndex < s.length() && s.charAt(i + rightIndex) >= 97 && s.charAt(i + rightIndex) <= 122) {
                    rightIndex++;
                }
                // указывает на последний печатный символ
                // i += rightIndex;
                String toRepeat = s.substring(i + 1, i + rightIndex + 1);
                stackLString.push(toRepeat);
                leftIndex = i + rightIndex;
            }
            if (s.charAt(i) == ']') {
                while (!stackLString.isEmpty()) {
                    Integer valueToRepeat = stackDigital.pop();
                    for (int n = 1; n <= valueToRepeat; n++) {
                        resultString.append(resultString.toString() + stackLString.pop());
                    }
                }
            }


        }

        return resultString.toString();
    }
}
