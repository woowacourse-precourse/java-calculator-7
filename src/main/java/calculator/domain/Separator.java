package calculator.domain;

public class Separator {
    private static final String CUSTOM_LENGTH_MESSAGE = "커스텀 구분자는 한 자만 가능합니다.";
    private static final String NOT_NUMBER_MESSAGE = "커스텀 구분자는 문자만 가능합니다.";

    private static final String defaultSeparator = "[,:]";
    private String customSeparator = "";

    public Separator(String inputValue) {
        String customSeparator = getCustomSeparator(inputValue);
        setCustomSeparator(customSeparator);
    }

    private void setCustomSeparator(String customSeparator) {
        if (!customSeparator.isEmpty()) {
            validate(customSeparator);
            this.customSeparator = escapeSeparator(customSeparator);
        }
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
        try {
            Integer.parseInt(customSeparator);
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        } catch (NumberFormatException e) {

        }
    }

    private String getCustomSeparator(String inputValue) {
        if (inputValue.startsWith("//")) {
            return inputValue.substring(2, inputValue.indexOf("\\n"));
        }
        return "";
    }

    public String[] splitBySeparator(String inputValue) {
        if (customSeparator.isEmpty()) {
            return inputValue.split(defaultSeparator);
        }
        String targetValue = inputValue.substring(5);
        return targetValue.split(customSeparator);
    }

    private String escapeSeparator(String customSeparator) {
        if (".[]{}()*+-?^$|".contains(customSeparator)) {
            return "\\" + customSeparator;
        }
        return customSeparator;
    }
}
