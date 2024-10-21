package calculator;

import java.util.Arrays;

public class Adder {

    private static final String DEFAULT_DELIM = "[,:]";
    private static final String CUSTOM_DELIM_PREFIX = "//";
    private static final String CUSTOM_DELIM_SUFFIX = "\\n";

    public int run(String input) {
        if (hasCustomDelim(input)) {
            String customDelim = input.substring(
                    input.indexOf(CUSTOM_DELIM_PREFIX) + CUSTOM_DELIM_PREFIX.length(),
                    input.indexOf(CUSTOM_DELIM_SUFFIX)
            );
            String numberString = input.substring(input.indexOf(CUSTOM_DELIM_SUFFIX) + CUSTOM_DELIM_SUFFIX.length());
            return run(numberString, customDelim);
        }
        return run(input, DEFAULT_DELIM);
    }

    private boolean hasCustomDelim(String input) {
        return input.startsWith(CUSTOM_DELIM_PREFIX) && input.contains(CUSTOM_DELIM_SUFFIX);
    }

    private int run(String numberString, String delim) {
        if (numberString.isEmpty()) {
            return 0;
        }
        return Arrays.stream(numberString.split(delim))
                .mapToInt(Integer::parseInt)
                .map(this::validateNumber)
                .sum();
    }

    private int validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력된 수가 음수이거나 0입니다.");
        }
        return number;
    }
}
