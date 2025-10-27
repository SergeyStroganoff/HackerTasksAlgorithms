package algo.interview_tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// find closest number than grater than given
public class ClosestSuperiorNumber {

    public static void main(String[] args) {
        int n = 999999;
        System.out.println(getClosestSuperiorNumber(n));
    }

    private static int getClosestSuperiorNumber(final int n) {
        if (n < 10) {
            return n + 1;
        }
        HashSet<Integer> set = new HashSet<>();
        int length = (int) Math.log10(n) + 1;
        int[] memory = new int[length];

        int f = n;
        for (int i = 0; i < length; i++) {
            int nextInt = f % 10;
            set.add(nextInt);
            memory[length - i - 1] = nextInt;
            f = f / 10;
        }
        if (set.size() >= 9) {
            return -1;
        }

        boolean isNumberChanged = false;
        for (int i = 0; i < length; i++) {
            if (isNumberChanged) {
                for (int m = 0; m < 10; m++) {
                    if (!set.contains(m)) {
                        memory[i] = m;
                        break;
                    }
                }
            } else {
                for (int m = memory[i]; m <= 10; m++) {
                    if (!set.contains(m)) {
                        int firstNumber = m;
                        if (m == 10) {
                            for (int k = 1; k < 9; k++) {
                                if (!set.contains(k)) {
                                    firstNumber = m * k;
                                    break;
                                }
                            }
                            for (int k = 0; k < 9; k++) {
                                if (!set.contains(k)) {
                                    firstNumber = firstNumber + k;
                                    break;
                                }
                            }
                        }
                        memory[i] = firstNumber;
                        isNumberChanged = true;
                        break;
                    }
                }
            }
        }
        String result = Arrays.stream(memory)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(result);
    }
}
