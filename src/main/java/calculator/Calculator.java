package calculator;

import static calculator.exception.Validator.checkNegativeNumber;
import static calculator.exception.Validator.isNumeric;

import calculator.io.InputView;
import calculator.io.OutputView;
import java.util.List;

public class Calculator {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Splitter splitter;
    private Long resultNumber = 0L;

    public Calculator() {
        String userInput = inputView.getInput();
        splitter = new Splitter(userInput);
    }

    public void stringSummation() {
        List<String> splitInput = splitter.splitString();
        Long[] numberOfInputString = changeStringToNumber(splitInput);
        sumNumber(numberOfInputString);
    }

    private Long[] changeStringToNumber(List<String> splitInput) throws IllegalArgumentException {
        Long[] numberOfInputString = new Long[splitInput.size()];
        for (int i = 0; i < splitInput.size(); i++) {
            long number = isNumeric(splitInput.get(i));
            checkNegativeNumber(number);
            numberOfInputString[i] = number;
        }
        return numberOfInputString;
    }

    private void sumNumber(Long[] numberArrays) {
        for (Long num : numberArrays) {
            resultNumber += num;
        }
    }

    public void getResult() {
        outputView.printResult(resultNumber);
        inputView.closedConsole();
    }
}
