package calculator.view;

public class OutputView {

    private static final String RESULT_COMMENT = "결과 : ";

    public String getResult(int answer) {
        return String.format("%s%d", RESULT_COMMENT, answer);
    }
}
