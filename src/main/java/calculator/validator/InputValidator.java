package calculator.validator;

public class InputValidator {

    public static void validateInput(String inputString) {
        containNegative(inputString);
    }

    public static void validateStringOperand(String[] operands) {
        validateTypeAndBound(operands);
        validateResultBound(operands);
    }

    private static void validateTypeAndBound(String[] operands) {
        for (String operand : operands) {
            if (!operand.equals("")) {
                try {
                    Integer.valueOf(operand);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("피연산자가의 범위가 int 범위를 초과합니다.");
                } catch (Exception e) {
                    throw new IllegalArgumentException("피연산자가 정상적으로 split되지 않습니다.");
                }
            }
        }
    }

    public static void validateResultBound(String[] operands) {
        int result = 0;
        for (String operand : operands) {
            if (!operand.equals("")) {
                if (result > Integer.MAX_VALUE - Integer.valueOf(operand)) {
                    throw new IllegalArgumentException("연산 결과의 범위가 int 범위를 초과합니다.");
                }
                result += Integer.valueOf(operand);
            }
        }
    }

    private static void containNegative(String inputString) {
        if (!inputString.startsWith("//-\\n")) {
            if (inputString.contains("-")) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}
