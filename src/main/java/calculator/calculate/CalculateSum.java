package calculator.calculate;

import java.util.Arrays;

public class CalculateSum {
    public static int calculateSum(int[] numbers) {
    return Arrays.stream(numbers).sum();
    }
}
