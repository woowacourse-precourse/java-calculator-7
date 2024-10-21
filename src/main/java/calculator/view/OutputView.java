package calculator.view;

public class OutputView {
    private static final String REQUEST_ADD_EXPRESSION = "덧셈할 문자열을 입력해 주세요.";
    private static final String PRINT_RESULT = "결과 : %d";

    public void requestAddExpression() {
        System.out.println(REQUEST_ADD_EXPRESSION);
    }

    public void printResult(int result) {
        System.out.println(String.format(PRINT_RESULT, result));
    }
}
