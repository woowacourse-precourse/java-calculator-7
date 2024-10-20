package calculator.model;

public class StringCalculation {

    public static final String NEGATIVE_INTEGER_ERROR_MESSAGE = "음수는 덧셈 대상이 아님";

    public int calculate(String[] expression) {
        if (expression[0].isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (String s : expression) {
            int operand = Integer.parseInt(s);
            if (operand < 0) {
                throw new IllegalArgumentException(NEGATIVE_INTEGER_ERROR_MESSAGE);
            }
            sum += operand;
        }
        return sum;
    }

}
