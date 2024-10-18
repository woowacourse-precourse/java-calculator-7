package calculator;

import java.util.Arrays;

public class Calculator {
    private static final String BASE_REGEX = ",|:";

    public static int calculate(String s) {
        try {
            String regex = BASE_REGEX;
            if (s.startsWith("//")) {
                String customSeparator = s.split("//|\\\\n")[1];
                s = s.split("//|\\\\n")[2];
                if (customSeparator.matches("\\\\")) {
                    customSeparator = "\\\\";
                }
                regex += "|" + customSeparator;
            }
            return Arrays.stream(s.split(regex))
                    .mapToInt(Integer::parseInt)
                    .peek(Calculator::validateNum)
                    .sum();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void validateNum(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
