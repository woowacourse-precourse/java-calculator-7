package calculator.application.validation;

import static calculator.domain.vo.delimiter.constants.DelimiterPattern.*;
import static calculator.infrastructure.exception.ErrorCode.*;

import calculator.application.dto.request.CalculationRequest;

public class InputValidator {

    public void validate(final CalculationRequest calculationRequest) {
        String target = calculationRequest.input();

        isEmpty(target);
        isNotTrimmed(target);
        isNotEndedWithNumber(target);
        isProperCustomDelimiter(target);
    }

    private void isEmpty(String target) {
        if (target.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY.getMessage());
        }
    }

    private void isNotTrimmed(String target) {
        if (!target.equals(target.trim())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_TRIMMED.getMessage());
        }
    }

    private void isNotEndedWithNumber(String target) {
        if (!Character.isDigit(target.charAt(target.length() - 1))) {
            throw new IllegalArgumentException(INPUT_IS_NOT_ENDED_WITH_NUMBER.getMessage());
        }
    }

    private void isProperCustomDelimiter(String target) {
        if(target.contains(CUSTOM_DELIMITER_PREFIX.getValue()) && !target.contains(CUSTOM_DELIMITER_SUFFIX.getValue())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
        }

        if(target.contains(CUSTOM_DELIMITER_SUFFIX.getValue()) && !target.contains(CUSTOM_DELIMITER_PREFIX.getValue())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
        }
    }
}