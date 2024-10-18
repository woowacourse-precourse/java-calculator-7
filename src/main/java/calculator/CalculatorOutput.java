package calculator;

public class CalculatorOutput {
    private static final String PRINT_PREFIX = "결과 : ";

    private CalculatorOutput() {
    }

    public static void print(double result) {
        System.out.println(PRINT_PREFIX + result);
    }
}
