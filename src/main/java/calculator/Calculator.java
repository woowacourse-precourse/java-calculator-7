package calculator;

import java.util.Arrays;

public class Calculator {
    public int calculate(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(this::convert)
                .sum();
    }

    private int convert(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        int parseInt = Integer.parseInt(string);
        if (parseInt < 0) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }

        return parseInt;
    }
}
