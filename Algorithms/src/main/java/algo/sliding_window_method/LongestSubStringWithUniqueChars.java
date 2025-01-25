package algo.sliding_window_method;

import java.util.HashMap;

/**
 * Пример 2: Наибольшая подстрока с уникальными символами
 * Задача: Найти длину самой длинной подстроки, содержащей только уникальные символы.
 * Если пустая ->0 и 1-> 1
 */

public class LongestSubStringWithUniqueChars {
    public static void main(String[] args) {
        LongestSubStringWithUniqueChars thisClassInstance = new LongestSubStringWithUniqueChars();

        String s = "abcscsccccc";
        System.out.println("Длина самой длинной подстроки с уникальными символами: " + thisClassInstance.lengthOfLongestSubstring(s)); // Вывод: 3
    }

    public String lengthOfLongestSubstring(String s) {
        // обработка крайних состояний
        if (s == null || s.isEmpty()) {
            return "0"; // Handle empty string
        }
        if (s.length() == 1) {
            return "" + 1;
        }
        int maxSubStringLength = 1;
        int rightIndex = 1;
        int leftIndex = 0;
        char[] stringCharBuf = s.toCharArray();
        // идем по символам строки
        HashMap<Character, Integer> window = new HashMap<>();
        window.put(stringCharBuf[leftIndex], leftIndex); // инициализируем мапу 1 символом и индексом
        while (rightIndex < stringCharBuf.length) {
            if (window.containsKey(stringCharBuf[rightIndex]) && window.get(stringCharBuf[rightIndex]) >= leftIndex) {
                //если в мапе уже есть такой символ то переставляем левый индекс на 1
                leftIndex = window.get(stringCharBuf[rightIndex]) + 1;
            }
            //добавляем новый символ и его значение в мапу
            window.put(stringCharBuf[rightIndex], rightIndex);
            maxSubStringLength = Math.max(maxSubStringLength, rightIndex - leftIndex);
            rightIndex++;
        }
        return String.valueOf(maxSubStringLength);
    }
}
