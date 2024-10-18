package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printResult(final int result) {
        System.out.printf(RESULT_MESSAGE + "%d", result);
    }
}
