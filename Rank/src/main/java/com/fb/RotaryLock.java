package com.fb;

/**
 * You're trying to open a lock. The lock comes with a wheel which has the integers from
 * 1 to N arranged in a circle in order around it (with integers N adjacent to one another).
 * The wheel is initially pointing at 1
 * For example, the following depicts the lock for
 * It takes 1 second to rotate the wheel by 1
 * 1 unit to an adjacent integer in either direction, and it takes no time to select an integer once the wheel is pointing at it.
 * The lock will open if you enter a certain code. The code consists of a sequence of M Determine the minimum number of seconds required to select all M
 * M of the code's integers in order.
 * Please take care to write a solution which runs within the time limit.
 */

public class RotaryLock {
    public static void main(String[] args) {
        System.out.println(getMinCodeEntryTime(10, 4, new int[]{9, 4, 4, 8}));
    }

    public static long getMinCodeEntryTime(int N, int M, int[] C) {
        int currentPosition = 1;
        long result = 0;
        int forwardRotation = 0;
        int backWardRotation = 0;
        for (int nextNumber : C) {
            if (nextNumber < currentPosition) {
                forwardRotation = nextNumber + N - currentPosition;
                backWardRotation = currentPosition - nextNumber;
            } else {
                forwardRotation = nextNumber - currentPosition; //
                backWardRotation = N - nextNumber + currentPosition; //
            }
            int clickTime = Math.min(forwardRotation, backWardRotation);
            currentPosition = nextNumber;
            result += clickTime;
        }
        return result;
    }
}
