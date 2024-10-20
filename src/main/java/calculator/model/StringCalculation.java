package calculator.model;

public class StringCalculation {

    public static final String NEGATIVE_INTEGER_ERROR_MESSAGE = "음수는 덧셈 대상이 아님";
    public static final String INTEGER_OVERFLOW = "정수형의 숫자 범위를 넘어갑니다";
    public static final int ZERO = 0;
    public static final int INTEGER_OVERFLOW_IS_NEGATIVE = 0;

    public int calculate(String[] expression) {
        if (expression[0].isEmpty()) {
            return 0;
        }
        int sum = 0;
        sum = calculateExpression(expression, sum);
        return sum;
    }

    private void validNegative(int operand) {
        if (operand < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    private void validOverFlow(int operand, int sum) {
        if (operand + sum < INTEGER_OVERFLOW_IS_NEGATIVE) {
            throw new IllegalArgumentException(INTEGER_OVERFLOW);
        }
    }

    private int calculateExpression(String[] expression, int sum) {
        for (String s : expression) {
            int operand = Integer.parseInt(s);
            validNegative(operand);
            validOverFlow(operand, sum);
            sum += operand;
        }
        return sum;
    }

}
