package calculator.validator;

public class OperandValidator {

    public static void validateStringOperand(String[] operands) {
        validateType(operands);
    }

    private static void validateType(String[] operands) {
        for (String operand : operands) {
            if (!operand.equals("")) {
                try {
                    Integer.valueOf(operand);
                } catch (Exception e) {
                    throw new IllegalArgumentException("피연산자가 정상적으로 split되지 않습니다.");
                }
            }
        }
    }
}
