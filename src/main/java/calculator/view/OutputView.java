package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE_FORMAT = "결과 : %d";

    public void printCalculateResult(int result) {
        System.out.printf(RESULT_MESSAGE_FORMAT, result);
    }
}
