package algo.stroganov.amazon.FizzBus;

import java.util.stream.IntStream;

/**
 * На вход поступают цифры
 * Надо сгенерировать последовательность от 1 до n
 * и в зависимости от их кратности напечатать строки
 */
public class Solution {

    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {

        IntStream.range(1, n + 1).forEach((x) -> testNumber(x));

    }

    public static void testNumber(int n) {
        if (n % 3 == 0) {
            if (n % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else if (n % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }
    }
}
