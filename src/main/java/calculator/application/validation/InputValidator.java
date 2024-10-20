package calculator.application.validation;

import static calculator.domain.vo.delimiter.constants.DelimiterPattern.*;
import static calculator.infrastructure.exception.ErrorCode.*;

import calculator.application.dto.request.CalculationRequest;

public class InputValidator {

    public void validate(final CalculationRequest calculationRequest) {
        String target = calculationRequest.input();

        validateNotTrimmed(target);
        validateEndedWithNumber(target);
        validateProperCustomDelimiterFormat(target);
    }

    private boolean isNotEmpty(String target) {
        if (target.isEmpty()) {
            return false;
        }
        return true;
    }

    private void validateNotTrimmed(String target) {
        if (isNotEmpty(target) && !target.equals(target.trim())) {
            throw new IllegalArgumentException(INPUT_IS_NOT_TRIMMED.getMessage());
        }
    }

    private void validateEndedWithNumber(String target) {
        if(target.startsWith(CUSTOM_DELIMITER_PREFIX.getValue()) && target.endsWith(CUSTOM_DELIMITER_SUFFIX.getValue())) {
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
}