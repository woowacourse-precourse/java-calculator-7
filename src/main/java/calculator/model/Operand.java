package calculator.model;

import static calculator.common.exception.ErrorMessage.INPUT_NOT_SUPPORTED_CHAR_ERROR;
import static calculator.common.exception.ErrorMessage.INPUT_ZERO_OR_NEGATIVE_VALUE_ERROR;

public record Operand(int number) {

    public static Operand from(String operand) {
        return new Operand(Validator.validate(operand));
    }

    private static class Validator {
        private static int validate(String operand) {
            int number = validateInteger(operand);
            validatePositive(number);
            return number;
        }

        private static int validateInteger(String operand) {
            try {
                return Integer.parseInt(operand);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INPUT_NOT_SUPPORTED_CHAR_ERROR);
            }
        }

        private static void validatePositive(int operand) {
            if (operand < 1) {
                throw new IllegalArgumentException(INPUT_ZERO_OR_NEGATIVE_VALUE_ERROR);
            }
        }
    }
}
