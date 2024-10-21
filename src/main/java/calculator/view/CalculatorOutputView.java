package calculator.view;

public class CalculatorOutputView {
    private static final String OUTPUT_EXPRESSION = "결과 : ";

    public void printOutputView(int result) {
        System.out.println(OUTPUT_EXPRESSION + result);
    }
}
