package calculator.application.validation;

import static calculator.domain.vo.delimiter.constants.DelimiterPattern.*;
import static calculator.domain.vo.number.constants.NumberRange.*;
import static calculator.infrastructure.exception.ErrorCode.*;

import calculator.application.dto.request.CalculationRequest;

public class InputValidator {

    private static final char DEFAULT_DELIMITER = '\0';

    public void validate(final CalculationRequest calculationRequest) {
        String target = calculationRequest.input();

        validateNotTrimmed(target);
        validateEndedWithNumber(target);
        validateProperCustomDelimiterFormat(target);
        validateProperNumberPart(extractNumberPart(target), extractCustomDelimiter(target));
    }

    private boolean isNotEmpty(String target) {
        return !target.isEmpty();
    }

    private void validateNotTrimmed(String target) {
        if (isNotEmpty(target) && !target.equals(target.trim())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_TRIMMED.getMessage());
        }
    }

    private void validateEndedWithNumber(String target) {
        if (target.startsWith(CUSTOM_DELIMITER_PREFIX.getValue()) && target.endsWith(CUSTOM_DELIMITER_SUFFIX.getValue())) {
            return;
        }

        if (isNotEmpty(target) && !Character.isDigit(target.charAt(target.length() - 1))) {
            throw new IllegalArgumentException(INPUT_IS_NOT_ENDED_WITH_NUMBER.getMessage());
        }
    }

    private void validateProperCustomDelimiterFormat(String target) {
        if (target.contains(CUSTOM_DELIMITER_PREFIX.getValue()) && !target.contains(CUSTOM_DELIMITER_SUFFIX.getValue())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
        }

        if (target.contains(CUSTOM_DELIMITER_SUFFIX.getValue()) && !target.contains(CUSTOM_DELIMITER_PREFIX.getValue())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
        }
    }

    private void validateProperNumberPart(String numberPart, char customDelimiter) {
        if (!isNotEmpty(numberPart)) {
            return;
        }

        String[] values = numberPart.split(generateCustomRegEx(customDelimiter));

        for (String value : values) {
            if (value.isEmpty()) {
                throw new IllegalArgumentException(CONSECUTIVE_DELIMITER.getMessage());
            }
        }
    }

    private String generateCustomRegEx(char customDelimiter) {
        if (customDelimiter == DEFAULT_DELIMITER) {
            return "[,:]";
        }
        return String.format("[,:%c]", customDelimiter);
    }

    private String extractNumberPart(String target) {
        if (target.startsWith(CUSTOM_DELIMITER_PREFIX.getValue()) && target.contains(CUSTOM_DELIMITER_SUFFIX.getValue())) {
            int delimiterEndIndex = target.indexOf(CUSTOM_DELIMITER_SUFFIX.getValue()) + CUSTOM_DELIMITER_SUFFIX.getValue().length();
            return target.substring(delimiterEndIndex).trim();
        }
        return target.trim();
    }

    private char extractCustomDelimiter(String target) {
        if (target.startsWith(CUSTOM_DELIMITER_PREFIX.getValue()) && target.contains(CUSTOM_DELIMITER_SUFFIX.getValue())) {
            return target.charAt(target.indexOf(CUSTOM_DELIMITER_PREFIX.getValue()) + CUSTOM_DELIMITER_PREFIX_LENGTH.getValue());
        }
        return DEFAULT_DELIMITER;
    }
}
