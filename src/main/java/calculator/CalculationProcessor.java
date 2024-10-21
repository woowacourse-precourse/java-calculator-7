package calculator;

import static calculator.util.InputIntegerParser.parseInputToInteger;
import static calculator.util.StringSplitter.splitUserInput;
import static calculator.validator.UserInputValidator.validateNegativeInteger;
import static calculator.view.InputView.getUserInput;
import static calculator.view.OutputView.printResult;
import static calculator.view.OutputView.printStartMessage;

import calculator.operations.Adder;
import calculator.operations.Calculator;

public class CalculationProcessor {
    Calculator calculator;

    public CalculationProcessor() {
        calculator = new Adder();
    }

    public void startCalculator() {
        printStartMessage();

        String userInput = getUserInput();

        String[] splitString = splitUserInput(userInput);

        Integer[] parsedNumbers = parseInputToInteger(splitString);

        validateNegativeInteger(parsedNumbers);

        int result = calculator.calculate(parsedNumbers);

        printResult(result);
    }
}
