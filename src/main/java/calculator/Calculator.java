package calculator;

import java.util.Arrays;

public class  Calculator {
    private final StringFilter stringFilter = new StringFilter();

    public int calculate(String input) {
        if (input.isEmpty())
            return 0;
        return Arrays.stream(stringFilter.convertToIntArray(input)).sum();
    }
}
