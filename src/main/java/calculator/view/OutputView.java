package calculator.view;

import calculator.constant.OutputMessage;

public class OutputView {

    public void printInputGuide() {
        System.out.println(OutputMessage.INPUT_GUIDE.getMessage());
    }
    public void printResult(int result) {
        System.out.println(OutputMessage.RESULT.getMessage() + result);
    }
}
