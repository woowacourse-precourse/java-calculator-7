package calculator;

public class ValueSum {
    public static int sumValue(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
