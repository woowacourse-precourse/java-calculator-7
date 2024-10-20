package calculator.controller.io;

import calculator.view.ConsoleView;

public class ConsoleOutputHandler implements OutputHandler {
    private final ConsoleView consoleView = new ConsoleView();

    @Override
    public void displayResult(Integer result) {
        consoleView.displayResult(result);
    }
}
