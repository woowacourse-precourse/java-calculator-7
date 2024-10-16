package calculator.domain;

public class NumberStringExtractor {

    private final CustomDelimiterExtractor customDelimiterExtractor;

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String NUMBER_FIRST_REGEX = "^[1-9].*";
    private static final String LAST_STRING_OF_CUSTOM_DELIMITER_FORMAT = "n";
    private static final int INCREASE_ONE_INDEX = 1;

    public NumberStringExtractor(CustomDelimiterExtractor customDelimiterExtractor) {
        this.customDelimiterExtractor = customDelimiterExtractor;
    }

    public String[] getStrings(String stringToAdd) {
        String customDelimiter = null;
        if (!isUsingOriginalDelimiter(stringToAdd)) {
            customDelimiter = customDelimiterExtractor.getCustomDelimiter(stringToAdd);
            stringToAdd = changeStringWithoutFormat(stringToAdd);
        }
        return stringToAdd.split("[" + customDelimiter + COLON + COMMA + "]");
    }

    private String changeStringWithoutFormat(String stringWithDelimiter) {
        int indexOfLastString = stringWithDelimiter.indexOf(LAST_STRING_OF_CUSTOM_DELIMITER_FORMAT);
        return stringWithDelimiter.substring(indexOfLastString + INCREASE_ONE_INDEX);
    }

    private boolean isUsingOriginalDelimiter(String stringWithDelimiter) {
        return stringWithDelimiter.startsWith(COMMA) ||
                stringWithDelimiter.startsWith(COLON) ||
                stringWithDelimiter.matches(NUMBER_FIRST_REGEX);
    }
}
