package calculator.validators;

public class InvalidCalculationException {
    public static void checkSumOverFlow(int a, int b) {
        try {
            Math.addExact(a, b);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("덧셈 과정에서 오버플로우가 발생했습니다");
        }
    }
}
