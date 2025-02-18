package com.fb;

/**
 * See Photography
 */
public class PhotographyMaxEffective {

    public static void main(String[] args) {
        String testString = "P.PAB";
        String testString2 = ".PBAAP.B";
        String testString3 = "APABA";
        // System.out.println(getArtisticPhotographCount(8, testString2, 1, 3));
        System.out.println(getArtisticPhotographCount(7, "P.A.B.P", 1, 3));
    }

    public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
        if (C.isEmpty()) {
            return 0;
        }
        return getValidCombination(C, X, Y, 'P', 'A', 'B') + getValidCombination(C, X, Y, 'B', 'A', 'P');
    }

    private static int getValidCombination(String C, int X, int Y, char first, char second, char third) {
        int result = 0;
        int charLengthInString = C.length();
        int[] firstOccurrenceArray = new int[charLengthInString];
        int[] thirdOccurrenceArray = new int[charLengthInString];
        firstOccurrenceArray[0] = C.charAt(0) == first ? 1 : 0;
        thirdOccurrenceArray[0] = C.charAt(0) == third ? 1 : 0;

        for (int i = 1; i < charLengthInString; i++) {
            int firstIsOnPosition = C.charAt(i) == first ? 1 : 0;
            int thirdIsOnPosition = C.charAt(i) == third ? 1 : 0;
            firstOccurrenceArray[i] = firstOccurrenceArray[i - 1] + firstIsOnPosition;
            thirdOccurrenceArray[i] = thirdOccurrenceArray[i - 1] + thirdIsOnPosition;
        }

        for (int i = 0; i < charLengthInString; i++) {
            if (C.charAt(i) == second) {
                if (i - Y < 0 && i + X >= C.length()) {
                    continue; // Skip cases where 'A' has no possible 'P' or 'B'
                }

                int countOfFirst = getCharOccurrenceInRange(firstOccurrenceArray, i - Y, i - X);
                int countOfThird = getCharOccurrenceInRange(thirdOccurrenceArray, i + X, i + Y);
                result += countOfFirst * countOfThird;
            }
        }
        return result;
    }

    //   .PBAAPB
    //P - [0, 1, 1, 1, 1, 2, 2, 2]


    private static int getCharOccurrenceInRange(int[] occurrenceArray, int left, int right) {
        if (right < 0 || left >= occurrenceArray.length) {
            return 0;
        }
        left = Math.max(0, left);
        right = Math.min(right, occurrenceArray.length - 1);
        if (left > right) {
            return 0;
        }
        return left == 0 ? occurrenceArray[right] : occurrenceArray[right] - occurrenceArray[left - 1];
    }

    private static int getCharOccurrenceInRange2(int[] occurrenceArray, int left, int right) {
        if (right < 0 || left >= occurrenceArray.length) {
            return 0;
        }
/*        if (left > right) {
            return 0;
        }*/
        left = Math.max(0, left);
        right = Math.min(right, occurrenceArray.length - 1);
        return left == 0 ? occurrenceArray[right] : occurrenceArray[right] - occurrenceArray[left - 1];
    }
}
