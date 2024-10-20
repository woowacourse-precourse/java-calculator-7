package calculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int CUSTOM_INPUT_START_INDEX = 5;
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String PARSE_ERROR_MESSAGE = "잘못된 값을 입력했습니다.";
    private final String[] formulas;

    public Calculator() {
        this("");
    }

    public Calculator(String input) {
        this.formulas = split(input);
    }

    private String[] split(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            String delimiter = Pattern.quote(input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX));
            input = input.substring(input.indexOf("\\n") + 2);  // "\\n" 이후의 문자열을 추출합니다.
            return input.split(delimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    public int sum() {
        return Arrays.stream(formulas).mapToInt(this::parse).sum();
    }

    private int parse(String input) {
        try {
            int number = Integer.parseInt(input.trim());  // trim을 추가하여 입력에서 공백을 제거합니다.
            return validate(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_ERROR_MESSAGE, e);
        }
    }

    private int validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        return number;
    }
}
