package algo.simple_algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BracketsChecker {

    public static void main(String[] args) {
        String testOne = "()";
        String testTwo = "(()";
        String testThree = "())";
        String testFour = "[(()))";
        String testFive = "([{}])";
        System.out.println(checkBrackets(testOne) ? "OK" : "FAIL");
    }

    private static boolean checkBrackets(String inputString) {
        Map<Character, Character> bracketsMatchMap = new HashMap<>();
        bracketsMatchMap.put(')', '(');
        bracketsMatchMap.put(']', '[');
        bracketsMatchMap.put('}', '{');
        Deque<Character> charactersStack = new ArrayDeque<>();
        for (int i = 0; i < inputString.length(); i++) {
            char nextChar = inputString.charAt(i);
            if (bracketsMatchMap.containsValue(nextChar)) {
                charactersStack.push(nextChar);
            } else {
                if (bracketsMatchMap.containsKey(nextChar)) {
                    if (!charactersStack.isEmpty() && charactersStack.peek().equals(bracketsMatchMap.get(nextChar))) {
                        charactersStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return charactersStack.isEmpty();
    }
}
