package calculator.domain;

public class StringAddCalculator {
    private static final String MIN_VALUE_ERROR = "양수만 입력가능합니다.";
    private static final int DEFAULT_VALUE = 0;

    private final Splitter splitter;

    public StringAddCalculator() {
        this(new Splitter());
    }

    public StringAddCalculator(final Splitter splitter) {
        this.splitter = splitter;
    }

    public int splitAndSum(final String inputValue) {
        if (isBlank(inputValue)) {
            return DEFAULT_VALUE;
        }
        return sum(splitter.convertToInt(inputValue));
    }

    private static boolean isBlank(final String inputValue) {
        return inputValue == null || inputValue.isEmpty();
    }

    private int sum(final int[] values) {
        int sum = 0;
        for (int value : values) {
            validateMinValue(value);
            sum += value;
        }
        return sum;
    }

    private void validateMinValue(final int value) {
        if (value <= DEFAULT_VALUE) {
            throw new IllegalArgumentException(MIN_VALUE_ERROR);
        }
    }
}
