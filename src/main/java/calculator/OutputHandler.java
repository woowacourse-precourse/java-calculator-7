package calculator;

public class OutputHandler {
    private static final String RESULT_MESSAGE_PREFIX = "결과 : ";

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE_PREFIX + result);
    }
}
