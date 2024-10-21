package calculator.view.handler;

import calculator.common.ConsoleMessage;

public class ConsoleOutputHandler implements OutputHandler {

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
