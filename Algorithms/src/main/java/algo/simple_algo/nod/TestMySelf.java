package algo.simple_algo.nod;

public class TestMySelf {
    public static void main(String[] args) {
        int a = 15;
        int b = 450;
        System.out.println(mySearchGCD(a, b));
    }

    private static int mySearchGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
