package popular_75.array_string;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 */
public class GreatestCommonDivider {

    public static void main(String... args) {
        String input = "aaabbaaaabbaaaabba";
        String input2 = "aaabba";
        System.out.println(gcdOfStrings(input, input2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        String shortString = str1.length() >= str2.length() ? str2 : str1;
        String longestString = str1.length() < str2.length() ? str2 : str1;
        if (longestString.length() % shortString.length() == 0
                && shortString.repeat(longestString.length() / shortString.length()).equals(longestString)) {
            return shortString;
        }

        for (int i = shortString.length() - 1; i > 0; i--) {
            String tempString = shortString.substring(0, i);
            int restOfDivisionStr1 = str1.length() % tempString.length();
            int restOfDivisionStr2 = str2.length() % tempString.length();
            if (restOfDivisionStr1 == 0 && restOfDivisionStr2 == 0) {
                String equivalentStr1 = tempString.repeat(str1.length() / tempString.length());
                String equivalentStr2 = tempString.repeat(str2.length() / tempString.length());
                if (equivalentStr1.equals(str1) && equivalentStr2.equals(str2)) {
                    return tempString;
                }
            }
        }
        return "";
    }


    public static String gcdOfStringsBest(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, getBiggestDivider(str1.length(), str2.length()));
    }

    private static int getBiggestDivider(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}
