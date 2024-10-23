package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
