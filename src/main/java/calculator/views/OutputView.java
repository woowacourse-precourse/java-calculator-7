package calculator.views;

public class OutputView {
    // 결과 메세지 헤더
    private static final String MESSAGE_HEADER = "결과 : ";

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printResult(int result) {
        System.out.println(MESSAGE_HEADER + result);
    }
}
