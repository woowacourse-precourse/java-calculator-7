package calculator.domain;

public class InputString {
    private static final String CUSTOM_PREFIX = CustomConst.PREFIX;
    private static final String CUSTOM_SUFFIX = CustomConst.SUFFIX;
    private final String value;

    public InputString(String input) {
        this.value = input;
    }

    public CustomDelimiter extractCustomDelimiter() {
        String customDelimiter = null;
        if (isValueHasCustomDelimiter()) {
            customDelimiter = value.substring(getCustomPrefixLength(), getCustomSuffixBeginIndex());
        }

        return new CustomDelimiter(customDelimiter);
    }

    public CalculationString extractCalculationString() {
        String calculationString = value;
        if (isValueHasCustomDelimiter()) {
            calculationString = value.substring(getCalculationStringBeginIndex());
        }

        return new CalculationString(calculationString);
    }

    private boolean isValueHasCustomDelimiter() {
        return value.startsWith(CUSTOM_PREFIX)
                && value.contains(CUSTOM_SUFFIX);
    }

    private int getCalculationStringBeginIndex() {
        return getCustomSuffixBeginIndex() + CUSTOM_SUFFIX.length();
    }

    private int getCustomPrefixLength() {
        return CUSTOM_PREFIX.length();
    }

    private int getCustomSuffixBeginIndex() {
        return value.lastIndexOf(CUSTOM_SUFFIX);
    }
}