package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printResult(final int result) {
        System.out.printf(RESULT_MESSAGE + "%d", result);
    }

    public static void printErrorMessage(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
