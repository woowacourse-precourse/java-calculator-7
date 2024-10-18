package calculator.util.exception;

import static calculator.util.exception.ErrorMessage.*;

public class CalculatorValidationException {

    public static class validateDelimiterAfterNewLinePresenceException extends IllegalArgumentException{
        public validateDelimiterAfterNewLinePresenceException() {
            super(CUSTOM_DELIMITER_NEED_NEWLINE.getMessage());
        }
    }

    public static class validateNonNegativeNumberException extends IllegalArgumentException{
        public validateNonNegativeNumberException() {
            super(IS_NOT_NUMBER_VALUE.getMessage());
        }
    }

    public static class validateSingleCharacterDelimiterException extends IllegalArgumentException{
        public validateSingleCharacterDelimiterException() {
            super(CUSTOM_DELIMITER_NOT_ALLOW_MULTIPLE.getMessage());
        }
    }

    public static class validateIsIntegerException extends IllegalArgumentException{
        public validateIsIntegerException() {
            super(IS_NOT_NUMBER_VALUE.getMessage());
        }
    }
}
