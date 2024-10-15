package calculator;

public class ConsoleWriter {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";
    public void writeInputQuery() {
        System.out.println(INPUT_MESSAGE);
    }
    public void writeResult(int result) {
        System.out.printf("%s%d%n", RESULT_MESSAGE, result);
    }
}
