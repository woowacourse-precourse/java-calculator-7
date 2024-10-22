package calculator;

public class MessagePrinter {

    private final String INPUT_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT_MESSAGE = "결과 : ";

    public void printInputRequest() {
        System.out.println(INPUT_REQUEST_MESSAGE);
    }

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
