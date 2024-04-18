package org.stroganov.roman_numerals;

public class RomanNumberTranslator {

    public static void main(String[] args) {
        System.out.println(translateToRomanNumber(500));
    }

    private static int[] valuesOfSymbols = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String translateToRomanNumber(int intValue) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (intValue != 0) {
            if (intValue >= valuesOfSymbols[i]) {
                stringBuilder.append(symbols[i]);
                intValue = intValue - valuesOfSymbols[i];
            } else {
                i++;
            }
        }
        return stringBuilder.toString();
    }
}
