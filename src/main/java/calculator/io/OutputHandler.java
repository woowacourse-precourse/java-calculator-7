package calculator.io;

public class OutputHandler {

    public static final String INITIAL_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE = "결과 : ";

    public void showInitialMessage() {
        System.out.println(INITIAL_MESSAGE);
    }

    public void showResultMessageWith(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

}
