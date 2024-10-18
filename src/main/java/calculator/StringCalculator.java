package calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty()) return 0;
        return Arrays.stream(input.split("[,|:]")).mapToInt(Integer::parseInt).sum();
    }
}

