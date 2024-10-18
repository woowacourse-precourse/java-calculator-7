package calculator.model.custom_delimiter.validator;

import calculator.common.exception.ExceptionFactory;

import static calculator.common.exception.ExceptionType.*;

public class DefaultCustomDelimiterValidator implements DelimiterValidator {

    private final String ESCAPE = "\\";
    private final String NUMBER_REGEX = ".*\\d.*";

    @Override
    public void validate(String delimiterString) {
        validateEmptyDelimiter(delimiterString);
        validateEscapeCharacter(delimiterString);
        validateForDigits(delimiterString);
    }

    private void validateEmptyDelimiter(String delimiterString) {
        if (delimiterString.isEmpty()) {
            throw ExceptionFactory.createException(CUSTOM_DELIMITER_EMPTY);
        }
    }

    private void validateEscapeCharacter(String delimiterString) {
        if (delimiterString.contains(ESCAPE)) {
            throw ExceptionFactory.createException(CUSTOM_DELIMITER_CONTAINS_ESCAPE);
        }
    }

    private void validateForDigits(String delimiterString) {
        if (delimiterString.matches(NUMBER_REGEX)) {
            throw ExceptionFactory.createException(CUSTOM_DELIMITER_CONTAINS_NUMBER);
        }
    }
}
