package calculator.view;

public class OutputView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.\n";
    private static final String RESULT_MESSAGE = "결과 : ";

    public void displayInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public void displayResultMessage(String number) {
        System.out.print(RESULT_MESSAGE + number);
    }
}
