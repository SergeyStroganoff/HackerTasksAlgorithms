package easy.reverse_integer;


public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }

    public static int reverse(int x) {
        if (x == 0) return 0;
        String minus = "";
        if (x < 0) {
            minus = "-";
            x = Math.abs(x);
        }
        String intAsString = String.valueOf(x);
        StringBuilder sb = new StringBuilder(intAsString);
        sb.reverse();
        sb.insert(0, minus);
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
