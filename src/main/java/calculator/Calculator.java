package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;

public class Calculator {

    private final Separator separator = new Separator();
    private final Result result = new Result();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

    public void run() {
        String input = getInputFromUser();

        if (input == null || input.isEmpty()) {
            input = "0";
        }

        String[] strings = separator.handleDelimiter(input);

        consoleOutputHandler.printResult(result.add(strings));
    }

    private String getInputFromUser() {
        consoleOutputHandler.showSumInputMessage();
        return consoleInputHandler.getUserInput();
    }
}
