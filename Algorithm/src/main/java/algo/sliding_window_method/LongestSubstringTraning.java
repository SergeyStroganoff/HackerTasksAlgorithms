package algo.sliding_window_method;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTraning {
    public static void main(String[] args) {
        String s = "abcscscccccc";
        System.out.println("Длина самой длинной подстроки с уникальными символами: " + lengthOfLongestSubstringUniqueChars(s)); // Вывод: 3
    }

    private static String lengthOfLongestSubstringUniqueChars(String s) {
        if (s == null || s.isEmpty())
            return String.valueOf(0);
        if (s.length() == 1)
            return String.valueOf(1);
        int maxUniqueSubstringLength = 0;
        char[] charArray = s.toCharArray();
        int left = 0;
        //int right = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < charArray.length; i++) {
            if (map.containsKey(charArray[i]) && map.get(charArray[i]) > left) {
                left = map.get(charArray[i]);
            }
            map.put(charArray[i], i);
            maxUniqueSubstringLength = Math.max(maxUniqueSubstringLength, i - left + 1);
        }
        return String.valueOf(maxUniqueSubstringLength);
    }


    private static int lengthOfLongestSubstringWithTheSameChars(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxLength = 0;
        char prevChar = s.charAt(0);
        int counter = 1;
        for (int n = 1; n < s.length(); n++) {
            if (s.charAt(n) == prevChar) {
                counter++;
                maxLength = Math.max(maxLength, counter);
            } else {
                counter = 1;
            }
            prevChar = s.charAt(n);

        }
        return maxLength;
    }
}
