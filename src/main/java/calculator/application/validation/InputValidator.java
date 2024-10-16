package calculator.application.validation;

import static calculator.infrastructure.exception.ErrorCode.*;

public class InputValidator {

    public void validate(String target) {
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
        if (target.contains("//") && target.contains("\n")) {
            String[] startRange = target.split("//");
            String[] endRange = startRange[1].split("\n");
            if (endRange[0].length() > 1 || !Character.isLetter(endRange[0].charAt(0))) {
	throw new IllegalArgumentException(
	    INPUT_IS_NOT_PROPER_CUSTOM_DELIMITER.getMessage());
            }
        }
    }
}

