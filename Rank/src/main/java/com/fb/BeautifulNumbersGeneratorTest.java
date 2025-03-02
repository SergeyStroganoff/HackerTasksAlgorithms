package com.fb;

import java.util.Random;

public class BeautifulNumbersGeneratorTest {

    public static void main(String[] args) {
        int testCases = 10; // Количество пар (можно изменить)
        generateAndTest(testCases);
    }

    public static void generateAndTest(int numberOfPairs) {
        Random random = new Random();
        long maxLimit = (long) Math.pow(10, 12); // 10^12

        for (int i = 0; i < numberOfPairs; i++) {
            long A = (long) (random.nextDouble() * maxLimit);
            long B = (long) (random.nextDouble() * maxLimit);

            if (A > B) {
                long temp = A;
                A = B;
                B = temp;
            }
            int resultTrue = BeautifulNumbersInRange.getUniformIntegerCountInIntervalShort(A, B);
            int resultTest = BeautifulNumbersInRange.getUniformIntegerCountInInterval(A, B);
            if (resultTrue != resultTest) {
                System.out.println(A + "," + B + " " + " resulttrue: " + resultTrue + "test: " + resultTest);
            }
        }
    }
}
