package calculator;

public class ConsoleDisplay implements Display {
    private static final String RESULT_MESSAGE_PREFIX = "결과 : ";

    @Override
    public void showResult(int result) {
        System.out.println(RESULT_MESSAGE_PREFIX + result);
    }
}
