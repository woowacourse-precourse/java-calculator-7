package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public void displayResult(Number result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
