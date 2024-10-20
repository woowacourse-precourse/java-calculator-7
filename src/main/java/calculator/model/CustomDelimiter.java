package calculator.model;

import calculator.util.ErrorMessage;
import calculator.util.Limit;
import calculator.util.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter extends Delimiter {
    public CustomDelimiter(String delimiter) {
        super(Pattern.quote(delimiter));
        validate();
    }

    @Override
    public void validate() {
        Matcher inValidDelimiter = createMatcher(Regex.CUSTOM_DELIMITER_INVALID_FORMAT.getRegex());
        Matcher duplicateDelimiter = createMatcher(Regex.DEFAULT_DELIMITER_FORMAT.getRegex());

        if (delimiter.length() > Limit.MAX_CUSTOM_DELIMITER.getValue() + Limit.REGEX_ESCAPE_CORRECTION.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_LIMIT.getError());
        }

        if (inValidDelimiter.find()) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_FORMAT.getError());
        }

        if (duplicateDelimiter.find()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CUSTOM_DEFAULT_DELIMITER.getError());
        }
    }

    private Matcher createMatcher(String regex) {
        Pattern customDelimiterPattern = Pattern.compile(regex);
        return customDelimiterPattern.matcher(delimiter);
    }
}
