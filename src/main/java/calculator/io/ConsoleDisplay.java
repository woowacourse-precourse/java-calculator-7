package calculator.io;

public class ConsoleDisplay implements Display {
    private static final String RESULT_MESSAGE_PREFIX = "결과 : ";
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.\n";

    @Override
    public void showResult(int result) {
        System.out.println(RESULT_MESSAGE_PREFIX + result);
    }

    public void showInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }
}
