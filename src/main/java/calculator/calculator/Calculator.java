package calculator.calculator;

import calculator.output.Output;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final String ORIGIN_DELIMITER_REGEX = ",|:";
    private final String CUSTOM_DELIMITER_PATTERN = "//(.*)\\\\n(.*)";

    public Calculator() {
    }

    public int add(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력 값이 null 또는 비어있을 수 없습니다.");
        }

        return Arrays.stream(split(input))
                .map(Integer::parseInt)
                .peek(this::validateNegative)
                .reduce(0, Integer::sum);
    }

    private String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String content = matcher.group(2);
            return content.split(Pattern.quote(customDelimiter));
        }

        return input.split(ORIGIN_DELIMITER_REGEX);
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private void validateNegative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("입력 값이 음수가 될 수 없습니다.");
        }
    }
}
