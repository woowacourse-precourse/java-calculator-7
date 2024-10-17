package calculator.view.output;

import calculator.common.ConsoleMessage;

public class OutputConsoleView implements OutputView {

    @Override
    public void requestInputValue() {
        println(ConsoleMessage.REQUEST_INPUT_VALUE);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
