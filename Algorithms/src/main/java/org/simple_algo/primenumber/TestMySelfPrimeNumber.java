package org.simple_algo.primenumber;

/**
 * Является ли код простым числом улучшенный код
 */

public class TestMySelfPrimeNumber {

    public static void main(String[] args) {
        int number = 11;
        System.out.println(isNumberPrime(number));
    }

    public static boolean isNumberPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) { // Handle the smallest prime
            return true;
        }
        if (number % 2 == 0) { // Eliminate even numbers greater than 2
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
