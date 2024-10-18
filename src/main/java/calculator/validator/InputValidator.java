package calculator.validator;

public class InputValidator {

    private static final String NEGATIVE_CUSTOM_DELIMITER = "//-\\n";
    private static final String NEGATIVE_SIGN = "-";
    private static final String BLANK = "";
    private static final String INPUT_ERROR = "입력값이 올바르지 않습니다.";
    private static final String OUT_OF_RANGE_ERROR = "int 범위를 초과합니다.";

    public static void validateInput(String inputString) {
        containNegative(inputString);
    }

    public static void validateStringOperand(String[] operands) {
        validateTypeAndBound(operands);
        validateResultBound(operands);
    }

    private static void validateTypeAndBound(String[] operands) {
        for (String operand : operands) {
            if (!operand.equals(BLANK)) {
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
            if (!operand.equals(BLANK)) {
                if (result > Integer.MAX_VALUE - Integer.valueOf(operand)) {
                    throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
                }
                result += Integer.valueOf(operand);
            }
        }
    }

    private static void containNegative(String inputString) {
        if (!inputString.startsWith(NEGATIVE_CUSTOM_DELIMITER)) {
            if (inputString.contains(NEGATIVE_SIGN)) {
                throw new IllegalArgumentException(INPUT_ERROR);
            }
        }
    }
}
