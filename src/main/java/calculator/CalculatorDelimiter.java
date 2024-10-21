package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorDelimiter {
    static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_HEAD = "//";
    private static final String CUSTOM_DELIMITER_LAST = "\n";
    private static final String  BACKSLASH_WITH_CUSTOM_DELIMITER_LAST= "\\n";
    private static final Integer CUSTOM_DELIMITER_LAST_SIZE = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+?)\\n(.*)");
    private static final Pattern CONTAINS_NUMBERS_PATTERN = Pattern.compile(".*\\d+.*");
    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("^[0-9,:,\\s]*$");


    public Boolean checkDelimiterHead(String userInput) {
        return userInput.startsWith(CalculatorDelimiter.CUSTOM_DELIMITER_HEAD);
    }

    public Matcher getMatcherByCheckPattern(String normalizedInput) {
        return CalculatorDelimiter.CUSTOM_DELIMITER_PATTERN.matcher(normalizedInput);
    }

    public Boolean isContainNumber(String givenInput) {
        return CalculatorDelimiter.CONTAINS_NUMBERS_PATTERN.matcher(givenInput).matches();
    }

    public Boolean isNotDefaultDelimiter(String givenInput) {
        return !CalculatorDelimiter.DEFAULT_DELIMITER_PATTERN.matcher(givenInput).matches();
    }

    public String changeToNormalizedInput(String givenInput) {
        return givenInput.replace(CalculatorDelimiter.BACKSLASH_WITH_CUSTOM_DELIMITER_LAST, CalculatorDelimiter.CUSTOM_DELIMITER_LAST);
    }

    public String subStringCustomDelimiterInput(String givenInput) {
        return  givenInput.substring(givenInput.indexOf(CalculatorDelimiter.BACKSLASH_WITH_CUSTOM_DELIMITER_LAST)
                            + CalculatorDelimiter.CUSTOM_DELIMITER_LAST_SIZE);
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

}
