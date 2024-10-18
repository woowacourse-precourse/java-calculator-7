package calculator.delimiter.service;

import calculator.common.exception.ExceptionFactory;

import static calculator.common.exception.ExceptionType.*;

public class NormalCustomDelimiterValidator implements CustomDelimiterValidator {

    private final String ESCAPE = "\\";
    private final String NUMBER_REGEX = ".*\\d.*";

    @Override
    public void validate(String customDelimiter) {
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
