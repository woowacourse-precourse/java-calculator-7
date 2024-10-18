package calculator.view;

public class OutputView {
    private final static String RESULT_PRINT_SENTENCE = "결과 : %d";
    private final static String START_PRINT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";

    public void printResult(int result) {
        System.out.printf(RESULT_PRINT_SENTENCE, result);
    }

    public void printStart() {
        System.out.println(START_PRINT_SENTENCE);
    }
}
