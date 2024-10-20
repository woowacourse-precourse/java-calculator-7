package calculator.model;

public class StringCalculation {

    public static int calculate(String[] expression) {
        if (expression[0].isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (String s : expression) {
            int operand = Integer.parseInt(s);
            if (operand < 0) {
                throw new IllegalArgumentException("음수는 덧셈 대상이 아님");
            }
            sum += operand;
        }
        return sum;
    }

}
