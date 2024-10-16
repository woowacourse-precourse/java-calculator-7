package calculator.view;

import calculator.global.constant.OutputMessage;

public class OutputView {

    public void printResult(int result) {
        System.out.println(OutputMessage.OUTPUT_PREFIX.getMessage() + result);
    }
}
