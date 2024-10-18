package calculator.delimiter.service;

import calculator.common.exception.ExceptionFactory;
import calculator.delimiter.domain.Delimiter;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.common.exception.ExceptionType.*;

public class CustomDelimiterService {

    private final String CUSTOM_DELIMITER_PREFIX = "//";
    private final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";
    private final String ESCAPE = "\\";
    private final String NUMBER_REGEX = ".*\\d.*";
    private final int DELIMITER_GROUP = 1;
    private final int TRIMMED_GROUP = 2;
    private final Pattern DELIMITER_PATTERN = Pattern.compile(
            "^" + CUSTOM_DELIMITER_PREFIX + "(.*)" + CUSTOM_DELIMITER_SUFFIX + "(.*)"
    );


    public Optional<Delimiter> extract(String value) {
        return Optional.ofNullable(value)
                .map(DELIMITER_PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> {
                    String extracted = matcher.group(DELIMITER_GROUP);
                    validate(extracted);
                    return new Delimiter(extracted);
                });
    }


    public String trimCustomDelimiter(String value) {
        return Optional.ofNullable(value)
                .map(DELIMITER_PATTERN::matcher)
                .filter(Matcher::find)
                .map(matcher -> matcher.group(TRIMMED_GROUP))
                .orElse(value);
    }


    private void validate(String customDelimiter) {
        validateEmptyDelimiter(customDelimiter);
        validateEscapeCharacter(customDelimiter);
        validateForDigits(customDelimiter);
    }

    private void validateEmptyDelimiter(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw ExceptionFactory.createException(CUSTOM_DELIMITER_EMPTY);
        }
    }

    private void validateEscapeCharacter(String customDelimiter) {
        if (customDelimiter.contains(ESCAPE)) {
            throw ExceptionFactory.createException(CUSTOM_DELIMITER_CONTAINS_ESCAPE);
        }
    }

    private void validateForDigits(String customDelimiter) {
        if (customDelimiter.matches(NUMBER_REGEX)) {
            throw ExceptionFactory.createException(CUSTOM_DELIMITER_CONTAINS_NUMBER);
        }
    }
}

