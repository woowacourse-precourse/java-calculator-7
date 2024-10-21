package calculator;

public class OutputView {
    private static final String INPUT_NUMBER_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_NUMBER_MESSAGE = "결과 : ";

    public void printInputNumber() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(RESULT_NUMBER_MESSAGE + result);
    }
}
