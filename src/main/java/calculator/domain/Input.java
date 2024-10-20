package calculator.domain;

public class Input {

    private static final String PART_SEPARATOR = "\\n";
    private static final String EMPTY_STRING = "";
    private static final String CONTAIN_DELIMITER_REGEX = "^//(.?)\\\\n.*";

    private final String delimiterPart;
    private final String numberPart;

    public Input(String invalidInput) {
        delimiterPart = extractDelimiterPart(invalidInput);
        numberPart = extractNumberPart(invalidInput);
    }

    private String extractDelimiterPart(String invalidInput) {
        if (isContainDelimiter(invalidInput)) {
            int substringIdx = invalidInput.indexOf(PART_SEPARATOR) + PART_SEPARATOR.length();

            return invalidInput.substring(0, substringIdx);
        }
        return EMPTY_STRING;
    }

    private String extractNumberPart(String invalidInput) {
        if (isContainDelimiter(invalidInput)) {
            int substringIdx = invalidInput.indexOf(PART_SEPARATOR) + PART_SEPARATOR.length();

            return invalidInput.substring(substringIdx);
        }
        return invalidInput;
    }

    private boolean isContainDelimiter(String invalidInput) {
        return invalidInput.matches(CONTAIN_DELIMITER_REGEX);
    }

    public String getDelimiterPart() {
        return delimiterPart;
    }

    public String getNumberPart() {
        return numberPart;
    }
}
