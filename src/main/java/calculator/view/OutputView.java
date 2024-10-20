package calculator.view;

public class OutputView {
    private static final String EXECUTION_RESULTS = "결과 : ";

    public static void executionResult(int result) {
        System.out.println(EXECUTION_RESULTS + result);
    }
}
