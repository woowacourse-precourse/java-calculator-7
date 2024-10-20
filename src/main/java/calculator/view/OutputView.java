package calculator.view;

public class OutputView {
    private static final String RESULT_PREFIX = "결과 : ";

    public static void printResult(int sum) {
        System.out.println(RESULT_PREFIX + sum);
    }
}
