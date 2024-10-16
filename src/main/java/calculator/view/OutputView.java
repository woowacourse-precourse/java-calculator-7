package calculator.view;

import calculator.enums.ViewMessage;

public class OutputView {

    public void printStart() {
        System.out.println(ViewMessage.START_CALCULATOR.getMessage());
    }

    public void printEnd() {
        System.out.println(ViewMessage.END_CALCULATOR.getMessage());
    }

    public void printResult(int result) {
        System.out.println(ViewMessage.RESULT.getMessage(result));
    }
}
