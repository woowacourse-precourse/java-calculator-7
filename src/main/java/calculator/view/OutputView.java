package calculator.view;

public class OutputView {

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";
    private static final String ERROR_MESSAGE = "잘못된 입력입니다: ";

    public static void printInputPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

    public static void printError(String message) {
        System.err.println(ERROR_MESSAGE + message);
    }
}
