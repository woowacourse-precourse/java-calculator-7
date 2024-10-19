package calculator.validator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidator implements BasicValidator<String> {
    private static final Pattern DEFAULT_INPUT_PATTERN = Pattern.compile("^\\d+([,:]\\d+)*$");
    private static final Pattern EMPTY_INPUT_REGEX = Pattern.compile("^$");
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\\\\n(.*)");

    @Override
    public void validate(String input) {
        if (!isDefaultInput(input) && !isCustomInput(input) && !isEmptyInput(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isDefaultInput(String input) {
        return DEFAULT_INPUT_PATTERN.matcher(input).matches();
    }

    private boolean isCustomInput(String input) {
        if (!CUSTOM_DELIMITER_REGEX.matcher(input).matches()) {
            return false;
        }
        String[] split = input.substring(2)
                .replaceAll("\\\\n", "\n")
                .split("\\n");

        if (split.length != 2) {
            return false;
        }

        String delimiter = split[0];
        String numbers = split[1];
        if (delimiter.isEmpty() || numbers.isEmpty()) {
            return false;
        }

        delimiter = Pattern.quote(delimiter);
        String[] splitNumbers = numbers.split(delimiter);
        return Arrays.stream(splitNumbers)
                .allMatch(this::isNumberPositive);
    }

    private boolean isNumberPositive(String splitNumber) {
        try {
            return Long.parseLong(splitNumber) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isEmptyInput(String input) {
        return EMPTY_INPUT_REGEX.matcher(input).matches();
    }
}
