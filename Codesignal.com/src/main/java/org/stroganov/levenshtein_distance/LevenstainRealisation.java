package org.stroganov.levenshtein_distance;

public class LevenstainRealisation {

    public int getLevenstainLength(String str1, String str2) {
        // Массивы должны быть одинаковой длины, т.к. отражают две строки (или столбца) одной и той же таблицы (см. алгоритм расстояния Левенштейна)
        int[] stringBufOne = new int[str2.length() + 1];
        int[] StringBufTwo = new int[str2.length() + 1];

        // Заполнение массивов начальными значениями
        for (int j = 0; j <= str2.length(); j++) {
            StringBufTwo[j] = j; // (i == 0)
        }

        for (int i = 1; i <= str1.length(); i++) {
            System.arraycopy(StringBufTwo, 0, stringBufOne, 0, stringBufOne.length);
            StringBufTwo[0] = i; // (j == 0)
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) != str2.charAt(j - 1)) ? 1 : 0;
                StringBufTwo[j] = min(
                        stringBufOne[j] + 1,
                        StringBufTwo[j - 1] + 1,
                        stringBufOne[j - 1] + cost
                );
            }
        }

        return StringBufTwo[StringBufTwo.length - 1];
    }

    private int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}
