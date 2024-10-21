package calculator.view;

public class OutputView {
    private static final String ADDITION_RESULT_OUTPUT_PREFIX = "결과 : ";

    private OutputView() {
    }

    public static void printSumResult(Integer sum) {
        System.out.println(ADDITION_RESULT_OUTPUT_PREFIX + sum);
    }
}