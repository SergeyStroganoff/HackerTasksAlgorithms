package algo.stepik.nod_number;

public class NODSolution {

    public static int getNodRecursive(int n, int m) {
        if (m == 0) {
            return n;
        }
        return getNodRecursive(m, n % m);
    }

    public static int findNOD(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;

        while (a != 0 && b != 0) { // until both a and b are zero
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) return b;
        else return a;
    }

}
