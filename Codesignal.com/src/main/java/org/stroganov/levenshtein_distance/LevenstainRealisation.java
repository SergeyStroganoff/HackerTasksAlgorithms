package org.stroganov.levenshtein_distance;

public class LevenstainRealisation {

    // Метод возвращает расстояние Левенштейна между двумя строками
    // ссылка на алгоритм: https://en.wikipedia.org/wiki/Levenshtein_distance
    // ссылка на обьяснение https://www.youtube.com/watch?v=4TgAdLQ9oVY&ab_channel=OleksandrTsymbaliuk

    public int getLevenstainLength(String str1, String str2) {
        // Массивы должны быть одинаковой длины, т.к. отражают две строки (или столбца) одной и той же таблицы (см. алгоритм расстояния Левенштейна)
        int[] UpLineOfMatricaBuf = new int[str2.length() + 1];
        int[] DownLineOfMatricaBuf = new int[str2.length() + 1];

        // Заполнение массивов начальными значениями
        for (int j = 0; j <= str2.length(); j++) {
            DownLineOfMatricaBuf[j] = j; // (i == 0)
        }

        // мы идем по строкам, поэтому внешний цикл идет по строкам
        // внутренний цикл идет по столбцам
        // Два цикла в первом мы берем буквы первой строки, во втором буквы второй строки и сравниваем их
        // Если буквы одинаковые, то берем значение из верхней строки подиаганали -  иначе берем минимальное значение из трех возможных


        for (int i = 1; i <= str1.length(); i++) {
            System.arraycopy(DownLineOfMatricaBuf, 0, UpLineOfMatricaBuf, 0, UpLineOfMatricaBuf.length);
            DownLineOfMatricaBuf[0] = i; // (j == 0)
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) != str2.charAt(j - 1)) ? 1 : 0;
                DownLineOfMatricaBuf[j] = min(
                        UpLineOfMatricaBuf[j] + 1,
                        DownLineOfMatricaBuf[j - 1] + 1,
                        UpLineOfMatricaBuf[j - 1] + cost
                );
            }
        }
        return DownLineOfMatricaBuf[DownLineOfMatricaBuf.length - 1];
    }

    // Метод возвращает минимальное значение из трех переданных
    private int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}
