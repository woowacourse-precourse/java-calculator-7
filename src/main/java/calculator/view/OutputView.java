package calculator.view;

import calculator.common.OutputMessage;

public class OutputView {
    public void printResult(String result) {
        System.out.println(OutputMessage.RESULT_MESSAGE.getMessage() + result);
    }
}
