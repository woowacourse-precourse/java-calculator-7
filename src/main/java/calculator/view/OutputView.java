package calculator.view;

public class OutputView {
    private static final String RESULT_FORMAT = "결과 : ";

    public static void printResult(int result) {
        System.out.println(RESULT_FORMAT + result);
    }
}
