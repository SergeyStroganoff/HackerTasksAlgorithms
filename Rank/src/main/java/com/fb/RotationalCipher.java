package com.fb;

/**
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
 * Rotating a character means replacing
 * it with another character that is a certain number of steps away in normal alphabetic or numerical order.
 */

public class RotationalCipher {

    public static void main(String[] args) {
        String test = "abcdZXYzxy-999.@";
        System.out.println(rotationalCipher(test, 200));
    }

    public static String rotationalCipher(String input, int rotationFactor) {


        char[] stringCharBuf = input.toCharArray();
        for (int i = 0; i < stringCharBuf.length; i++) {
            int rotation = 0;
            if (stringCharBuf[i] >= 48 && stringCharBuf[i] <= 57) {
                rotation = stringCharBuf[i] + rotationFactor % 10 > 57 ? 47 + rotationFactor % 10 - (57 - stringCharBuf[i]) : stringCharBuf[i] + rotationFactor % 10;
                stringCharBuf[i] = (char) rotation;
            }
            if (stringCharBuf[i] >= 65 && stringCharBuf[i] <= 90) {
                rotation = stringCharBuf[i] + rotationFactor % 26 > 90 ? 64 + rotationFactor % 26 - (90 - stringCharBuf[i]) : stringCharBuf[i] + rotationFactor % 26;
                stringCharBuf[i] = (char) rotation;
            }
            if (stringCharBuf[i] >= 97 && stringCharBuf[i] <= 122) {
                rotation = stringCharBuf[i] + rotationFactor % 26 > 122 ? 96 + rotationFactor % 26 - (122 - stringCharBuf[i]) : stringCharBuf[i] + rotationFactor % 26;
                stringCharBuf[i] = (char) rotation;
            }
        }
        return String.valueOf(stringCharBuf);
    }

}
