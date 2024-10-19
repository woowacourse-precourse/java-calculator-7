package calculator.view;

public class OutputView {
    public static final String OUTPUT_MESSAGE = "결과 : ";
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public void printCalculatorResult(String result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }

    public void errorPage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
