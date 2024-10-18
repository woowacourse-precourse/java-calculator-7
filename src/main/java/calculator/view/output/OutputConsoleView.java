package calculator.view.output;

import calculator.common.ConsoleMessage;

public class OutputConsoleView implements OutputView {

    @Override
    public void requestInputValue() {
        println(ConsoleMessage.REQUEST_INPUT_VALUE);
    }

    @Override
    public void printMessage(String message) {
        println(message);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
