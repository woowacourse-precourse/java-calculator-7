package calculator;

import java.util.Arrays;

public class Calculator {
    private static final String BASE_REGEX = ",|:";

    public static int calculate(String s) {
        return Arrays.stream(s.split(BASE_REGEX))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
