package calculator.utils;

import calculator.exception.CalculatorException;
import calculator.exception.CalculatorExceptionStatus;

public class InputValidator {

    private static final String CUSTOM_DELIMITER_FORMAT = "^//.\\\\n.*";
    private static final String CHECK_NEGATIVE_INTEGER_FORMAT = ".*-\\d+.*";
    private static final String CHECK_DEFAULT_DELIMITER_FORMAT = "[0-9,|:\\.]+";
    private static final int CUSTOM_DELIMITER_IDX = 2;
    private static final int CUSTOM_DELIMITER_EXPRESSION_START_IDX = 5;

    public static void validateInput(String input) {

        if (input.matches(CHECK_NEGATIVE_INTEGER_FORMAT)) {
            throw new CalculatorException(
                    CalculatorExceptionStatus.INVALID_NEGATIVE_INTEGER);
        }

        // 커스텀 구분자 사용하는 경우
        if (input.matches(CUSTOM_DELIMITER_FORMAT)) {
            String delimiter = String.valueOf(input.charAt(CUSTOM_DELIMITER_IDX));
            String expression = input.substring(CUSTOM_DELIMITER_EXPRESSION_START_IDX);

            if(delimiter.equals("."))
                throw new CalculatorException(CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_DOT);

            if (Character.isDigit(delimiter.charAt(0))) {
                throw new CalculatorException(
                        CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_INTEGER);
            }

            for (char c : expression.toCharArray()) {
                if (!Character.isDigit(c) && !String.valueOf(c).equals(delimiter) && !String.valueOf(c).equals(".")) {
                    throw new CalculatorException(
                            CalculatorExceptionStatus.INVALID_CUSTOM_DELIMITER_EXPRESSION);
                }
            }
            return;
        }

        // 기본 구분자를 사용하는 경우
        if (!input.isEmpty() && !input.matches(CHECK_DEFAULT_DELIMITER_FORMAT)) {
            throw new CalculatorException(
                    CalculatorExceptionStatus.INVALID_DEFAULT_DELIMITER_EXPRESSION);
        }


    }
}
