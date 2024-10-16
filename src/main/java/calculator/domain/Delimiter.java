package calculator.domain;

public class Delimiter {

    // TODO 일급 컬렉션으로 Delimiter 구현
    private static final String DELIMITER_JOINER = "|";
    private static final String BLANK_STRING = "";
    private static final int BEGIN_INDEX = 2;
    private static final String CUSTOM_DELIMITER_END_SEPARATOR = "\n";
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_START_SEPARATOR = "//";

    public String getAllDelimiters(final String input) {
        final String customDelimiter = findCustomDelimiter(input);

        return DEFAULT_DELIMITERS + customDelimiter;
    }

    private String findCustomDelimiter(final String input) {
        if (hasCustomDelimiter(input)) {
            return DELIMITER_JOINER + input.substring(BEGIN_INDEX, input.indexOf(CUSTOM_DELIMITER_END_SEPARATOR));
        }

        return BLANK_STRING;
    }

    public boolean hasCustomDelimiter(final String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_SEPARATOR);
    }
}
