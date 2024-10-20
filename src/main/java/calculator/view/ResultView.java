package calculator.view;

public class ResultView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public void printResult(int result) {
        System.out.printf("%s%d%n", RESULT_MESSAGE, result);
    }
}
