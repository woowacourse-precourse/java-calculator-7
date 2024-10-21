package calculator;

public class View {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE = "결과 : ";

    public void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
