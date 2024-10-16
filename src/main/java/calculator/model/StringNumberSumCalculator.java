package calculator.model;

import java.util.Arrays;

public class StringNumberSumCalculator {

    public static int sum(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}