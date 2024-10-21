package calculator.view;


public class OutputView {
    private static final String RESULT_PREFIX = "결과 : ";

    public void printResult(String result) {
        System.out.println(RESULT_PREFIX + result);
    }
}
