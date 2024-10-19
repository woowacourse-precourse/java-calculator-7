package calculator.view;

public class OutputView {
    private final static String APPLICATION_START_PREFIX = "덧셈할 문자열을 입력해주세요.";
    private final static String RESULT_PRINT_PREFIX = "결과 : ";

    public void printStart() {
        System.out.println(APPLICATION_START_PREFIX);
    }

    public void printResult(int result) {
        System.out.println(RESULT_PRINT_PREFIX + result);
    }
}
