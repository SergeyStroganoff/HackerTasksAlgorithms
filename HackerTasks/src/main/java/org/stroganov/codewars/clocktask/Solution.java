package org.stroganov.codewars.clocktask;

public class Solution {
    public static void main(String[] args) {
        int result = circleOfNumbers(6, 3);
        System.out.println("Sulution: " + result);
    }

    public static int circleOfNumbers(int n, int firstNumber) {
        // your code here
        int pintsToHalfCircle = n / 2;
        int numberOfPoint = firstNumber + pintsToHalfCircle;
        int stepsFromFirstPointToTheEndOfCircle = n - firstNumber;
        int stepsFromStartCircle = numberOfPoint - stepsFromFirstPointToTheEndOfCircle;
        if (stepsFromStartCircle >= 0) {
            return stepsFromStartCircle;
        }
        return numberOfPoint;
    }
}
