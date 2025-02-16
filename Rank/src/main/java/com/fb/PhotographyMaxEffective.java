package com.fb;

/**
 * See Photography
 */
public class PhotographyMaxEffective {

    public static void main(String[] args) {
        String testString = "P.PAB";
        String testString2 = ".PBAAP.B";
        System.out.println(getArtisticPhotographCount(8, testString2, 1, 3));
    }

    public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
        return getValidCombination(C, X, Y, 'P', 'A', 'B') + getValidCombination(C, X, Y, 'B', 'A', 'P');
    }

    private static int getValidCombination(String C, int X, int Y, char first, char second, char third) {
        int result = 0;
        int charLengthInString = C.length();
        int[] firstOccurrenceArray = new int[charLengthInString + 1];
        int[] secondOccurrenceArray = new int[charLengthInString + 1];
        int[] thirdOccurrenceArray = new int[charLengthInString + 1];

        for (int i = 1; i < charLengthInString + 1; i++) {
            int firstIsOnPosition = C.charAt(i - 1) == first ? 1 : 0;
            //  int secondIsOnPosition = C.charAt(i - 1) == second ? 1 : 0;
            int thirdIsOnPosition = C.charAt(i - 1) == third ? 1 : 0;

            //   secondOccurrenceArray[i] = secondOccurrenceArray[i - 1] + secondIsOnPosition;
            firstOccurrenceArray[i] = firstOccurrenceArray[i - 1] + firstIsOnPosition;
            thirdOccurrenceArray[i] = thirdOccurrenceArray[i - 1] + thirdIsOnPosition;
        }

        for (int i = 0; i < charLengthInString; i++) {
            if (C.charAt(i) == second) {
                int countOfFirst = getCharOccurrenceInRange(firstOccurrenceArray, i - Y, i - X);
                int countOfThird = getCharOccurrenceInRange(thirdOccurrenceArray, i + X, i + Y);
                // System.out.println("First counts:" + countOfFirst);
                // System.out.println("Third counts:" + countOfThird);
                result += countOfFirst * countOfThird;
            }
        }
        return result;
    }

    //0,0,0,1,2,2,2,2
    //  P,B,A,A,B,B,B
    private static int getCharOccurrenceInRange(int[] secondOccurrenceArray, int left, int right) {
        if (right < 0 || left > secondOccurrenceArray.length) {
            return 0;
        }
        left = Math.max(0, left);
        right = Math.min(right, secondOccurrenceArray.length - 2);
        return secondOccurrenceArray[right + 1] - secondOccurrenceArray[left];
    }
}
