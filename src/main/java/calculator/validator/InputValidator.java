package calculator.validator;

import calculator.constant.Constant;

public class InputValidator {

    private static final String INPUT_ERROR = "입력값이 올바르지 않습니다.";
    private static final String OUT_OF_RANGE_ERROR = "int 범위를 초과합니다.";

    public static void validateInput(String inputString) {
        containNegative(inputString);
        validateCustomFormat(inputString);
    }

    private static void containNegative(String inputString) {
        if (!inputString.startsWith(Constant.NEGATIVE_CUSTOM_DELIMITER)) {
            if (inputString.contains(Constant.NEGATIVE_SIGN)) {
                throw new IllegalArgumentException(INPUT_ERROR);
            }
        }
    }

    private static void validateCustomFormat(String inputString) {
        if (inputString.startsWith(Constant.CUSTOM_DELIMITER_PREFIX)) {
            if (!inputString.substring(Constant.CUSTOM_DELIMITER_SUFFIX_START, Constant.CUSTOM_DELIMITER_SUFFIX_END)
                    .equals(Constant.CUSTOM_DELIMITER_SUFFIX)) {
                throw new IllegalArgumentException(INPUT_ERROR);
            }
        }
    }

    public static void validateStringOperand(String[] operands) {
        validateBlank(operands);
        validateTypeAndBound(operands);
        validateResultBound(operands);
    }

    private static void validateBlank(String[] operands) {
        if (operands.length > 1) {
            for (String operand : operands) {
                if (operand.equals(Constant.BLANK)) {
                    throw new IllegalArgumentException(INPUT_ERROR);
                }
            }
        }
    }

    private static void validateTypeAndBound(String[] operands) {
        for (String operand : operands) {
            if (!operand.equals(Constant.BLANK)) {
                try {
                    Integer.valueOf(operand);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(e.getMessage());
                } catch (Exception e) {
                    throw new IllegalArgumentException(INPUT_ERROR);
                }
            }
        }
    }

    public static void validateResultBound(String[] operands) {
        int result = 0;
        for (String operand : operands) {
            if (!operand.equals(Constant.BLANK)) {
                if (result > Integer.MAX_VALUE - Integer.valueOf(operand)) {
                    throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
                }
                result += Integer.valueOf(operand);
            }
        }
    }
}
