package calculator.view;

public class OutputView {

    private static final String OPERATION_RESULT_PROMPT = "결과 : ";

    public void printResult(int result) {
        System.out.println(OPERATION_RESULT_PROMPT + result);
    }
}
