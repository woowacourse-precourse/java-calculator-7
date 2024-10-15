package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String NUMBER_FORMAT_ERROR = "숫자값만 입력가능합니다.";
    private static final String MIN_VALUE_ERROR = "양수만 입력가능합니다.";
    private static final int DEFAULT_VALUE = 0;
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TARGET_STRING_INDEX = 2;

    public StringAddCalculator() {
    }

    public int splitAndSum(final String inputValue) {
        if (isBlank(inputValue)) {
            return DEFAULT_VALUE;
        }
        return sum(inputValue);
    }

    private static boolean isBlank(final String inputValue) {
        return inputValue == null || inputValue.isBlank();
    }

    private String[] splitStringByRegx(final String inputValue) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputValue);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return matcher.group(TARGET_STRING_INDEX).split(customDelimiter);
        }
        return inputValue.split(DELIMITER);
    }

    private int sum(final String inputValue) {
        int[] values = convertToInt(inputValue);
        int sum = 0;
        for (int value : values) {
            validateMinValue(value);
            sum += value;
        }
        return sum;
    }

    private int[] convertToInt(final String inputValue) {
        String[] values = splitStringByRegx(inputValue);
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            validateNumberValue(values[i]);
            result[i] = Integer.parseInt(values[i]);
        }
        return result;
    }

    private void validateNumberValue(final String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private void validateMinValue(final int value) {
        if (value <= DEFAULT_VALUE) {
            throw new IllegalArgumentException(MIN_VALUE_ERROR);
        }
    }
}
