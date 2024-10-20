package calculator.io;

public class OutputHandler {
    public static final String ENTRY_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE = "결과 : ";

    public void showEntryMessage() {
        System.out.println(ENTRY_MESSAGE);
    }

    public void showCalculatedValue(int cost) {
        System.out.println(RESULT_MESSAGE + cost);
    }
}