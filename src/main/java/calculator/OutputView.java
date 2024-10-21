package calculator;

public class OutputView {
    private static final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_FORMAT= "결과 : %d";

    public static void printStartMessage() {
        System.out.println(INPUT_REQUEST_MESSAGE);
    }

    public static void printSumResult(int sum) {
        System.out.printf(RESULT_FORMAT, sum);
    }
}
