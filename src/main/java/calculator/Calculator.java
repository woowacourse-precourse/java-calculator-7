package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class Calculator {

    private final static String NUMBERICPATTERN = "\\d+";

    private final Separator separator = new Separator();
    private final Result result = new Result();
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Calculator(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        String input = getInputFromUser();

        if (hasUserInput(input)) {
            outputHandler.printResult(0);
            return;
        }

        String[] strings = separator.handleDelimiter(input);

        String[] validateNumber = validateNumber(strings);

        outputHandler.printResult(result.add(validateNumber));
    }

    private boolean hasUserInput(String input) {
        return input == null || input.isEmpty();
    }

    private String[] validateNumber(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].isEmpty()) {
                strings[i] = "0";
            }
            if (!strings[i].matches(NUMBERICPATTERN)) {
                throw new IllegalArgumentException();
            }
        }
        return strings;
    }

    private String getInputFromUser() {
        outputHandler.showSumInputMessage();
        return inputHandler.getUserInput();
    }

}
