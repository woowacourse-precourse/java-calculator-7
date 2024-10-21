package calculator.presentation;

public final class Viewer {

    private static final String INPUT_STRING_TO_ADD = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_IS = "결과 : ";

    private Viewer() {
    }

    public static void inputMessage() {
        System.out.println(INPUT_STRING_TO_ADD);
    }

    public static void resultMessage(final Long answer) {
        System.out.println(RESULT_IS + answer);
    }
}
