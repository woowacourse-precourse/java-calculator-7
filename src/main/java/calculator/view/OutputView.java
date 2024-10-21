package calculator.view;

public class OutputView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public void inputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public void resultMessage(String number) {
        System.out.println(RESULT_MESSAGE + number);
    }
}