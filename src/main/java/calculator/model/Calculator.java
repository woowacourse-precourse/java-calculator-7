package calculator;

public class Calculator {
    private ConsoleHandler consoleHandler;

    public Calculator(ConsoleHandler consoleHandler) {
        this.consoleHandler = consoleHandler;
    }

    public void run() {
        String input = consoleHandler.getInput();
        consoleHandler.consoleOutput(input);
    }
}
