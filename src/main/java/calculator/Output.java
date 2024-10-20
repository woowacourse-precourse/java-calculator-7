package calculator;

public class Output {
    private static final String INITIAL_COMMENT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_COMMENT = "결과 : ";

    public Output() {
        System.out.println(INITIAL_COMMENT);
    }

    public void printResult(int result) {
        System.out.print(RESULT_COMMENT + result);
    }
}
