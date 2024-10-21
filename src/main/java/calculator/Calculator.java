package calculator;

import static calculator.util.Adder.addNumbers;
import static calculator.util.InputIntegerParser.parseInputToInteger;
import static calculator.util.StringSplitter.splitUserInput;
import static calculator.validator.UserInputValidator.validateNegativeInteger;
import static calculator.view.InputView.getUserInput;
import static calculator.view.OutputView.printResult;
import static calculator.view.OutputView.printStartMessage;

public class Calculator {
    public void startCalculator() {
        printStartMessage();

        String userInput = getUserInput();

        String[] splitString = splitUserInput(userInput);

        Integer[] parsedNumbers = parseInputToInteger(splitString);

        validateNegativeInteger(parsedNumbers);

        Integer result = addNumbers(parsedNumbers);

        printResult(result);
    }
}
