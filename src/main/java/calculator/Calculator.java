package calculator;

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

    private void sumNumber(Long[] numberArrays) {
        for (Long num : numberArrays) {
            resultNumber += num;
        }
    }

    private Long[] changeStringToNumber(List<String> splitInput) throws IllegalArgumentException {
        Long[] numberOfInputString = new Long[splitInput.size()];
        for (int i = 0; i < splitInput.size(); i++) {
            long number = Long.parseLong(splitInput.get(i));
            checkNegativeNumber(number);
            numberOfInputString[i] = number;
        }
        return numberOfInputString;
    }

    private void checkNegativeNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void getResult() {
        outputView.printResult(resultNumber);
        inputView.closedConsole();
    }


}
