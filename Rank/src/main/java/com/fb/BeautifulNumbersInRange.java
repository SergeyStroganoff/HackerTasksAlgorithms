package com.fb;

/**
 * В диапазоне от А до Б найти количество красивых цифр
 * Число красивое если все цифры в нем одинаковы
 * <p>
 * Решение:
 * - в диапазоне от 10 до 50 - x=(50/10-10/10)- 0 - 1 т.е  вхождение первого и вхождение второго.
 * - в диапазоне от 10 до 35    x= (35-10)/10 + 1 последнее число больше чем предыдущее
 * - в диапазоне от 15 до 25 = x = (25-10)/10 + 1
 * т.е. нам надо определить дает ли первое число карсивое значение и дает ли втрое и посчитать значения между ними
 * итак: 25 - 94 = 94/10-25/10 = 7 - !вхождение в первый десяток?1 - !вхождения во второй десяток?1;
 * <p>
 * - в диапазоне от 15 до 100 -  х = 100/10 - 10/10 - вхождение по верхней границе числа
 * (10 +++) - вхождение по нижней границе 100 --
 * <p>
 * <p>
 * <p>
 * - в диапазоне от 100 до 1000 - х =(1000/100 - 100/100) - вхождение - вхождение  =9-0-1
 * - в диапазоне от 5 до 1235 - считаем:
 * --- в диапазоне от 5 до 10  - 5 вхождений
 * --- в диапазоне от 10 до 100  - 9 вхождений
 * --- в диапазоне от 100 до 1235 - 9 + 1111 т.е. еще одно вхождение
 * <p>
 * <p>
 * Если 1234 - 12456  = т.е. отнять с нижней границы если уже пропустили и прибавить по верхней если добавили
 * <p>
 * Т.е. нам надо понимать с каким размером числа мы имеем дело
 * далее считать диапазон исходя и пространства между ними
 */

public class BeautifulNumbersInRange {

    public static void main(String[] args) {
        long A = 83755484052L;
        long B = 142610823767L;
        System.out.println(getUniformIntegerCountInInterval(A, B));
        System.out.println(getUniformIntegerCountInIntervalShort(A, B));
    }

    // more slaw but right code;

    public static int getUniformIntegerCountInIntervalShort(long A, long B) {
        int count = 0;

        // Генерируем все красивые числа и проверяем их на попадание в диапазон
        for (long i = 1; i <= B; i = i * 10 + 1) { // 1, 11, 111, 1111, ..., 10^12+1
            for (int d = 1; d <= 9; d++) { // Перебираем цифры от 1 до 9
                long beautifulNumber = i * d;
                if (beautifulNumber >= A && beautifulNumber <= B) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int getUniformIntegerCountInInterval(long A, long B) {
        if (A == B) {
            return isBeautiful(A) ? 1 : 0;
        }
        int result;
        // Считаем количество десятков в числах
        int dimensionA = getDigitsInNumber(A);
        int dimensionB = getDigitsInNumber(B);
        int diff = dimensionB - dimensionA;
        result = diff * 9;
        // если первое число уже пропустило сколько:, то красивых значений, — то надо уменьшить результат
        // как получить первую цифру любого значения - надо поделить на количество десяток это число
        int firstDigitA = (int) (A / (Math.pow(10, dimensionA - 1)));
        int firstDigitB = (int) (B / (Math.pow(10, dimensionB - 1)));
        long borderA = 0;
        for (int i = 0; i < dimensionA; i++) {
            borderA += firstDigitA * Math.pow(10, i);
        }
        long borderB = 0;
        for (int i = 0; i < dimensionB; i++) {
            borderB += firstDigitB * Math.pow(10, i);
        }
        result = A > borderA ? result - firstDigitA : result - firstDigitA + 1;
        result = B >= borderB ? result + firstDigitB : result + firstDigitB - 1;
        return result;
    }

    public static int getDigitsInNumber(long number) {
        int result = 0;
        while (number > 0) {
            number /= 10;
            result++;
        }
        return result;
    }

    // Проверка, является ли число "красивым"
    private static boolean isBeautiful(long number) {
        //берем последнюю цифру
        long digit = number % 10;
        // откусываем от числа по чуть и сравниваем - если хоть одна цифра не последня - значит это не красивое число
        while (number > 0) {
            if (number % 10 != digit) return false;
            number /= 10;
        }
        return true;
    }
}
