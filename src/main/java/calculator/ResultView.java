package calculator;

public class ResultView {
    private final static String PRINT_INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";
    private final static String PRINT_RESULT = "결과 : %d\n";
    public static void printInputString() {
        System.out.println(PRINT_INPUT_STRING);
    }

    public static void printResult(int result) {
        System.out.printf(PRINT_RESULT,result);
    }
}
