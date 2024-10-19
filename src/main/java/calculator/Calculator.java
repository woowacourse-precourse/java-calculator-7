package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;

public class Calculator {

    private final static String NUMBERICPATTERN = "\\d+";

    private final Separator separator = new Separator();
    private final Result result = new Result();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

    public void run() {
        String input = getInputFromUser();

        if (input == null || input.isEmpty()) {
            consoleOutputHandler.printResult(0);
            return;
        }

        String[] strings = separator.handleDelimiter(input);

        validateNumber(strings);

        consoleOutputHandler.printResult(result.add(strings));
    }

    private static void validateNumber(String[] strings) {
        for (String value : strings) {
            if (!value.matches(NUMBERICPATTERN))
                throw new IllegalArgumentException();
        }
    }

    private String getInputFromUser() {
        consoleOutputHandler.showSumInputMessage();
        return consoleInputHandler.getUserInput();
    }
}
