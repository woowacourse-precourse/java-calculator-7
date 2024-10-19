package calculator.view;

public class OutputView {
    private final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT_FORMAT = "결과 : %s";

    public void requestInput() {
        System.out.println(INPUT_GUIDE);
    }

    public void displayResult(String result) {
        System.out.printf(RESULT_FORMAT, result);
    }
}
