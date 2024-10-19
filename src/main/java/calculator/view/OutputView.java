package calculator.view;

public class OutputView {
    private static final String CALCULATE_RESULT_MESSAGE = "결과 : ";
    public void printResult(Integer result) {
        System.out.println(CALCULATE_RESULT_MESSAGE + result);
    }
}
