package calculator.view;

public class OutputView {
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
