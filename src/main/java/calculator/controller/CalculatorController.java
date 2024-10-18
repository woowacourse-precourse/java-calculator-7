package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private static final String BEGIN_COMMAND = "//";
    private static final String END_COMMAND = "\\n";
    private static final String MAJOR_DELIMITER = ",";
    private static final String MINOR_DELIMITER = ":";
    private static String input;

    public void runCalculator() {
        OutputView.printInitialMessage();
        readInput();
        String delimiter = decideDelimiter();
        String[] numberGroup = Calculator.separateNumber(input, delimiter);
        OutputView.printResult(Calculator.findSum(numberGroup));
    }

    private void readInput() {
        input = InputView.inputStringWithoutSpaces();
    }

    private String decideDelimiter() {
        if (input.substring(0, 2).equals(BEGIN_COMMAND)) {
            int indexOfEndCommand = input.indexOf(END_COMMAND);
            String customDelimiter = input.substring(2, indexOfEndCommand);
            input = input.substring(indexOfEndCommand + END_COMMAND.length());
            return customDelimiter;
        } else {
            input = input.replace(MINOR_DELIMITER, MAJOR_DELIMITER);
            return MAJOR_DELIMITER;
        }
    }
}
