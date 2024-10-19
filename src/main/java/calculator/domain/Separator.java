package calculator.domain;

public class Separator {
    private static final String CUSTOM_LENGTH_MESSAGE = "커스텀 구분자는 한 자만 가능합니다.";
    private static final String NOT_NUMBER_MESSAGE = "커스텀 구분자는 문자만 가능합니다.";

    private static final String defaultSeparator = "[,:]";
    private String customSeparator = null;

    public Separator(String inputValue) {
        setCustomSeparator(inputValue);
    }

    public String[] splitBySeparator(String inputValue) {
        if (customSeparator == null) {
            return inputValue.split(defaultSeparator);
        }
        String targetValue = inputValue.substring(5);
        return targetValue.split(customSeparator);
    }

    private void setCustomSeparator(String inputValue) {
        if (hasCustomSeparator(inputValue)) {
            String customSeparator = getCustomSeparator(inputValue);
            validate(customSeparator);
            this.customSeparator = escapeSeparator(customSeparator);
        }
    }

    private Boolean hasCustomSeparator(String inputValue) {
        return inputValue.startsWith("//") && inputValue.indexOf("\\n") >= 2;
    }

    private String getCustomSeparator(String inputValue) {
        return inputValue.substring(2, inputValue.indexOf("\\n"));
    }

    private void validate(String customSeparator) {
        validateLength(customSeparator);
        validateLetter(customSeparator);
    }

    private void validateLength(String customSeparator) {
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException(CUSTOM_LENGTH_MESSAGE);
        }
    }

    private void validateLetter(String customSeparator) {
        if (customSeparator.matches("\\d")) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    private String escapeSeparator(String customSeparator) {
        if (".[]{}()*+-?^$|".contains(customSeparator)) {
            return "\\" + customSeparator;
        }
        return customSeparator;
    }
}
