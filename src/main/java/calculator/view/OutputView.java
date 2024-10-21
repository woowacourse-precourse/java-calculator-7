package calculator.view;

public class OutputView {
    private static final String REQUEST_ADDITION_INPUT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE_PREFIX = "결과 : ";

    public static void printNotice() {
        System.out.println(REQUEST_ADDITION_INPUT);
    }

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE_PREFIX + result);
    }
}
