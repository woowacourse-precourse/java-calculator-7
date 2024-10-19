package calculator.view;

public class OutputView {
    public static final String OUTPUT_MESSAGE = "결과 : ";

    public void printCalculatorResult(String result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
