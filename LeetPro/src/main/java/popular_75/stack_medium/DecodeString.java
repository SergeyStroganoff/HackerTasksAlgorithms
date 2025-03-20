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
        String testString2 = "3[a]2[bc]";
        String testString3 = "abc3[cd]xyz";
        String testString4 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        //zzz yypqjkjkjkjkjkjkjkjkefyypqjkjkjkjkjkjkjkjkef ef   ef
        System.out.println(testString);
        System.out.print(decodeStringNew(testString));

    }
    public static String decodeString(String s) {

        String intermediateResultString = "";
        StringBuilder result = new StringBuilder();
        Stack<Integer> stackDigital = new Stack<>();
        Stack<String> stackLString = new Stack<>();
        int leftIndex = 0;
        int currentPosition = 0;
        while (currentPosition < s.length()) {
            // если встретили открывающую скобу - парсим число перед скобой от leftIndex до скобы
            if (s.charAt(currentPosition) == '[') {
                String numberString = s.substring(leftIndex, currentPosition);
                int value = Integer.parseInt(numberString);
                stackDigital.push(value);
                //поиск всех символов справа от скобки [
                int rightIndex = currentPosition;
                while (rightIndex + 1 < s.length() && s.charAt(rightIndex + 1) >= 97 && s.charAt(rightIndex + 1) <= 122) {
                    rightIndex++;
                }
                // строка для приращения и повторения
                String toRepeat = s.substring(currentPosition + 1, rightIndex + 1);
                stackLString.push(toRepeat);
                // сдвигаем текущую позиция на индекс за строку
                currentPosition = rightIndex + 1;
                leftIndex = rightIndex + 1;
            }
            if (s.charAt(currentPosition) == ']' && !stackDigital.isEmpty()) {
                Integer valueToRepeat = stackDigital.pop();
                String toRepeat = stackLString.pop() + intermediateResultString;
                String repeatedString = toRepeat.repeat(valueToRepeat);
                intermediateResultString = repeatedString;
                //acc acc acc
                if (stackLString.isEmpty()) {
                    result.append(intermediateResultString);
                    intermediateResultString = "";
                }
                leftIndex++;
                currentPosition++;
            } else {
                if (s.charAt(currentPosition) >= 97 && s.charAt(currentPosition) <= 122) {
                    result.append(s.charAt(currentPosition));
                    leftIndex++;
                } else {
                    //  stackDigital.push(Integer.parseInt(String.valueOf(s.charAt(currentPosition))));
                    //  stackDigital.push(4);
                }
                currentPosition++;
            }
        }
        return result.toString();
    }

    public static String decodeStringNew(String decodeString) {
        Stack<Integer> bracketPositions = new Stack<>();
        Stack<Integer> multiplierStack = new Stack<>(); //??
        Stack<String> stringStack = new Stack<>();
        StringBuilder mainString = new StringBuilder();
        int lastLeftPosition = -1;
        for (int i = 0; i < decodeString.length(); i++) {

            //прибавляем все символы в вне брекетов
            if (bracketPositions.isEmpty() && decodeString.charAt(i) >= 97 && decodeString.charAt(i) <= 122) {
                mainString.append(decodeString.charAt(i));
            }
            if (decodeString.charAt(i) == '[') {
                bracketPositions.push(i);
                multiplierStack.push(getMultiplier(decodeString, i));
                stringStack.push("");
            }
            if (decodeString.charAt(i) == ']') {
                int leftPosition = bracketPositions.pop();
                int multiplier = multiplierStack.pop();
                String currentString = stringStack.pop();
                if (bracketPositions.isEmpty() && stringStack.isEmpty()) {
                    String string = currentString + decodeString.substring(leftPosition + 1, i);
                    string = string.repeat(multiplier);
                    mainString.append(string);
                } else {
                    if (!stringStack.isEmpty()) {
                        String string = currentString + decodeString.substring(leftPosition + 1, i);

                    }


/*                    String s = decodeString(decodeString.substring(leftPosition + 1, i));
                    s = s.repeat(multiplier);
                    mainString.append(s);*/
                }

            }
        }
        return mainString.toString();
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
}

// If meet alphabet add to current string as continues
// If meet [ -> than
//        -  save position of open ->
//        -  save value of multiplier
//        -  start new empty string and push to stack

// If meet close:
// - get entire string or get result and multipli
