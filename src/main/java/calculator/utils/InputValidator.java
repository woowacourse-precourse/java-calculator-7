package calculator.utils;


import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;

public class InputValidator {

    private static final String CUSTOM_DELIMITER_FORMAT = "^//.\\\\n.*";
    private static final String CHECK_NEGATIVE_INTEGER_FORMAT = ".*-\\d+.*";
    private static final String CHECK_CUSTOM_DELIMITER_INTEGER_FORMAT = ".*-\\d+.*";
    private static final String CHECK_DEFAULT_DELIMITER_FORMAT = "[0-9,|:]+";
    private static final int CUSTOM_DELIMITER_IDX = 2;
    private static final int CUSTOM_DELIMITER_EXPRESSION_START_IDX = 5;

    public void validateInput(String input) {

        if (input.matches(CHECK_NEGATIVE_INTEGER_FORMAT)) {
            throw new CalculatorException(
                    CalculatorExceptionStatus.INVALID_NEGATIVE_INTEGER);
        }

        if (input.matches(CUSTOM_DELIMITER_FORMAT)) {
            String delimiter = String.valueOf(input.charAt(CUSTOM_DELIMITER_IDX));
            String expression = input.substring(CUSTOM_DELIMITER_EXPRESSION_START_IDX);

            if (input.matches(CHECK_CUSTOM_DELIMITER_INTEGER_FORMAT)) {
                throw new CalculatorException(
                        CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_INTEGER);
            }

            for (char c : expression.toCharArray()) {
                if (!Character.isDigit(c) && !String.valueOf(c).equals(delimiter)) {
                    throw new CalculatorException(
                            CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_EXPRESSION);
                }
            }
            return;
        }

        if (!input.matches(CHECK_DEFAULT_DELIMITER_FORMAT)) {
            throw new CalculatorException(
                    CalculatorExceptionStatus.INVALID_DEFAULT_DELIMITER_EXPRESSION);
        }
    }
}
