package calculator;

import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;

public class Calculator {

    private final Spliterator spliterator;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n");

    public Calculator(Spliterator spliterator) {
        this.spliterator = spliterator;
    }

    public int calculate(String input) {
        String customDelimiter = extractCustomDelimiter(input);
        input = removeCustomInput(input, customDelimiter);
        String[] parse = spliterator.split(input, customDelimiter);
        return Arrays.stream(parse)
                .mapToInt(parseStringToInt())
                .sum();
    }

    private String extractCustomDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            String[] parts = input.split("\\\\n", 2);
            return parts[0].substring(2);
        }
        return "";
    }

    private boolean hasCustomDelimiter(String expression) {
        return CUSTOM_DELIMITER_PATTERN.matcher(expression).find();
    }

    private String removeCustomInput(String input, String customDelimiter) {
        if (!customDelimiter.isBlank()) {
            String[] parts = input.split("\\\\n", 2);
            return parts[1];
        }
        return input;
    }

    private ToIntFunction<String> parseStringToInt() {
        return value -> {
            int num = Integer.parseInt(value);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return num;
        };
    }
}
