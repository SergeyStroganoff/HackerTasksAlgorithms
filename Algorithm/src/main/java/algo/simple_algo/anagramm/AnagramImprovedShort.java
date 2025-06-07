package algo.simple_algo.anagramm;

import java.util.HashMap;
import java.util.Map;

public class AnagramImprovedShort {
    public static void main(String... args) {
        String test1 = "test";
        String test2 = "stef";
        System.out.print(isAnagram(test1, test2));
    }

    private static boolean isAnagram(String test1, String test2) {
        if (test1.length() != test2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < test1.length(); i++) {
            map.merge(test1.charAt(i), 1, (oldV, newV) -> oldV + newV == 0 ? null : oldV + newV);
            map.merge(test2.charAt(i), -1, (oldV, newV) -> oldV + newV == 0 ? null : oldV + newV);
        }
        return map.size() == 0;
    }
}
