package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorDelimiter {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_HEAD = "//";
    private static final String CUSTOM_DELIMITER_LAST = "\n";
    private static final String  BACKSLASH_WITH_CUSTOM_DELIMITER_LAST= "\\n";
    private static final Integer CUSTOM_DELIMITER_LAST_SIZE = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+?)\\n(.*)");
    private static final Pattern CONTAINS_NUMBERS_PATTERN = Pattern.compile(".*\\d+.*");
    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("^[0-9,:,\\s]*$");

    private boolean matchesPattern(Pattern pattern, String input) {
        return pattern.matcher(input).matches();
    }
    public Matcher getMatcherByCheckPattern(String normalizedInput) {
        return CUSTOM_DELIMITER_PATTERN.matcher(normalizedInput);
    }
    public boolean isContainNumber(String givenInput) {
        return matchesPattern(CONTAINS_NUMBERS_PATTERN, givenInput);
    }
    public boolean isDefaultDelimiter(String givenInput) {
        return matchesPattern(DEFAULT_DELIMITER_PATTERN, givenInput);
    }
    public Boolean checkDelimiterHead(String userInput) {
        return userInput.startsWith(CUSTOM_DELIMITER_HEAD);
    }
    public Boolean checkDelimiterLast(String userInput) {
        return userInput.contains(BACKSLASH_WITH_CUSTOM_DELIMITER_LAST);
    }
    public String changeToNormalizedInput(String givenInput) {
        return givenInput.replace(BACKSLASH_WITH_CUSTOM_DELIMITER_LAST, CUSTOM_DELIMITER_LAST);
    }
    public String subStringCustomDelimiterInput(String givenInput) {
        return  givenInput.substring(givenInput.indexOf(BACKSLASH_WITH_CUSTOM_DELIMITER_LAST)
                            + CUSTOM_DELIMITER_LAST_SIZE);
    }
    public String getCustomDelimiterIfPresent(String userInput,String givenDelimiter) {
        if (checkDelimiterHead(userInput)) {
            return Pattern.quote(givenDelimiter) + "|" + DEFAULT_DELIMITER;
        }
        return DEFAULT_DELIMITER;
    }
    public String stripCustomDelimiterFromInput(String userInput) {
        if (checkDelimiterHead(userInput)) {
            return subStringCustomDelimiterInput(userInput);
        }
        return userInput;
    }
    public Boolean isCustomDelimiterFormat(String givenInput) {
        return this.checkDelimiterHead(givenInput) && this.checkDelimiterLast(givenInput);
    }
    public Boolean isNotHaveAnyDelimiterFormat(String givenInput) {
        return !this.isCustomDelimiterFormat(givenInput) && !this.isDefaultDelimiter(givenInput);
    }
}
