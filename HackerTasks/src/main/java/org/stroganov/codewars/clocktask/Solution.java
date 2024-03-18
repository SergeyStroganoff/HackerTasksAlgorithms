package org.stroganov.codewars.clocktask;

public class Solution {
    public static void main(String[] args) {
        int result = circleOfNumbers(360, 3);
        System.out.println("Solution: " + result);
    }

    public static int circleOfNumbers(int n, int firstNumber) {
        // your code here
        return (firstNumber + n / 2) % n;
    }
}
