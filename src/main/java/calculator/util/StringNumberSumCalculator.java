package calculator.util;

import java.util.Arrays;

public class StringNumberSumCalculator {

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }

}