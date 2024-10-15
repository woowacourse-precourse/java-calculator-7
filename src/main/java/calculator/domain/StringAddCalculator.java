package calculator.domain;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String NUMBER_FORMAT_ERROR = "숫자값만 입력가능합니다.";
    private static final String MIN_VALUE_ERROR = "양수만 입력가능합니다.";
    private static final int DEFAULT_VALUE = 0;

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

    private String[] splitString(final String inputValue) {
        if (inputValue.startsWith(CUSTOM_DELIMITER_START) && inputValue.contains(CUSTOM_DELIMITER_END)) {
            int delimiterEnd = inputValue.indexOf(CUSTOM_DELIMITER_END);
            String customDelimiter = inputValue.substring(CUSTOM_DELIMITER_START.length(), delimiterEnd);
            return inputValue.substring(delimiterEnd + CUSTOM_DELIMITER_END.length())
                    .split(customDelimiter);
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
        String[] values = splitString(inputValue);
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
