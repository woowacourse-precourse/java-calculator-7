package calculator.domain;

public class InputString {
    private static final String CUSTOM_PREFIX = CustomConst.PREFIX;
    private static final String CUSTOM_SUFFIX = CustomConst.SUFFIX;
    private final String value;

    public InputString(String input) {
        this.value = input;
    }

    public CustomDelimiter extractCustomDelimiter() {
        if (!isValueHasCustomDelimiter()) {
            return null;
        }

        String customDelimiter = value.substring(getCustomPrefixLength(), getCustomSuffixIndex());
        return new CustomDelimiter(customDelimiter);
    }

    public CalculationString extractCalculationString() {
        if (!isValueHasCustomDelimiter()) {
            return new CalculationString(value);
        }

        String calculationString = value.substring(getCalculationStringIndex());
        return new CalculationString(calculationString);
    }

    private boolean isValueHasCustomDelimiter() {
        return value.startsWith(CUSTOM_PREFIX)
                && value.contains(CUSTOM_SUFFIX);
    }

    private int getCalculationStringIndex() {
        return getCustomSuffixIndex() + CUSTOM_SUFFIX.length();
    }

    private int getCustomPrefixLength() {
        return CUSTOM_PREFIX.length();
    }

    private int getCustomSuffixIndex() {
        return value.lastIndexOf(CUSTOM_SUFFIX);
    }
}