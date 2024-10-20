package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : %s";

    public void printResult(String result) {
        System.out.printf(RESULT_MESSAGE, result);
    }
}
