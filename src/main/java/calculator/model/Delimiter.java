package calculator.model;

import static calculator.model.ExceptionMessage.DELIMITER_SIZE_EXCEPTION;
import static calculator.model.ExceptionMessage.EMPTY_DELIMITER_EXCEPTION;
import static calculator.model.token.ParsingPattern.DEFAULT_DELIMITER_PATTERN;

public class Delimiter {

    private final String delimiter;

    private static final int DELIMITER_SIZE = 1;

    public Delimiter(String delimiter) {
        if (delimiter.equals(DEFAULT_DELIMITER_PATTERN.getPattern())) {
            this.delimiter = delimiter;
            return;
        }
        validate(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }


    private void validate(String delimiter) {
        validateEmptyDelimiter(delimiter);
        validateSize(delimiter);
    }

    private void validateEmptyDelimiter(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_DELIMITER_EXCEPTION.getMessage());
        }
    }

    private void validateSize(String delimiter) {
        if (delimiter.length() != DELIMITER_SIZE) {
            throw new IllegalArgumentException(DELIMITER_SIZE_EXCEPTION.getMessage());
        }
    }
}
