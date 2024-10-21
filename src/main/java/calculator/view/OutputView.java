package calculator.view;

public class OutputView {
    private final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT_MESSAGE = "결과 : ";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(Integer number) {
        System.out.println(RESULT_MESSAGE + number);
    }
}
