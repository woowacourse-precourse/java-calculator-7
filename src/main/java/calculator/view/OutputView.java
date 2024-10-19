package calculator.view;

public class OutputView {
    private final String RESULT_MESSAGE = "결과 : ";

    public void printResult(Integer result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
