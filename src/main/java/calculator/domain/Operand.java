package calculator.domain;

public class Operand {
    private final static String NOT_STRING_MESSAGE = "숫자가 아닌 문자열이 입력되었습니다.";
    private final static String NOT_POSITIVE_MESSAGE = "입력된 숫자가 양수가 아닙니다.";

    private int operand;

    public Operand(String element) {
        this.operand = parseToInt(element);
        validatePositive(this.operand);
    }

    private int parseToInt(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_STRING_MESSAGE);
        }
    }

    private void validatePositive(int operand) {
        if (operand <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
        }
    }

    public int getOperand() {
        return operand;
    }
}
