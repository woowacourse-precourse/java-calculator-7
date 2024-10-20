package calculator.view;

import calculator.constant.message.OutputMessage;

public class OutputView {

    private OutputView() {
    }

    // private 클래스이므로 외부에서 접근할 수 없다.
    private static class OutputViewHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.INSTANCE;
    }

    public void requestString() {
        System.out.println(OutputMessage.INPUT_STRING.getMessage());
    }

    public void showResult(Long result) {
        System.out.println(OutputMessage.RESULT.getMessage() + result);
    }
}
