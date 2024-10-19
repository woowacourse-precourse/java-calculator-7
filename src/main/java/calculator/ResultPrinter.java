package calculator;

public class ResultPrinter {
    private final String RESULT_PREFIX = "결과 : ";

    public void printResult(int result) {
        System.out.println(RESULT_PREFIX + result);
    }
}
