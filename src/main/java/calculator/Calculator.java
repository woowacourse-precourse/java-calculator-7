package calculator;

import java.util.Arrays;

public class Calculator {

    public static int calculateSum(String[] strNumArray) {
        return Arrays.stream(strNumArray)
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
