package calculator.domain;

import calculator.exception.ErrorMessage;

public class CustomDelimiter {

    private static final int FIX_SIZE = 1;
    private static final String NUMBER_TYPE = "\\d";

    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        validateLength(delimiter);
        validateType(delimiter);
        validateIsDefault(delimiter);
        this.delimiter = delimiter;
    }

    private void validateLength(String delimiter) {
        if (delimiter.length() != FIX_SIZE) {
            throw new IllegalArgumentException(String.format(ErrorMessage.CUSTOM_LENGTH_IS_FIX.getMessage(), FIX_SIZE));
        }
    }

    private void validateType(String delimiter) {
        if (delimiter.matches(NUMBER_TYPE)) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_TYPE_IS_NOT_NUMBER.getMessage());
        }
    }

    private void validateIsDefault(String delimiter) {
        if (delimiter.equals(DefaultDelimiter.FIRST.getDelimiter()) || delimiter.equals(
                DefaultDelimiter.SECOND.getDelimiter())) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_CANT_BE_DEFAULT.getMessage());
        }
    }
}