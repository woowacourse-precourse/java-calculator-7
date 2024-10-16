package calculator;

public class ResultPrinter {

    private static final String RESULT_MESSAGE_PREFIX = "결과 : ";

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE_PREFIX + result);
    }
}
