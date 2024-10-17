package calculator.output;

public class Output {

    private static final String SUM_STRING_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printInputMessage() {
        System.out.println(SUM_STRING_INPUT_MESSAGE);
    }

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
