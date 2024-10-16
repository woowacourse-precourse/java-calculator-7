package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final Calculator calculator = new Calculator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startCalculate() {
        String expression = inputView.inputExpressionString();
        int[] extractNumberAry = extractNumbers(expression);
        calculator.sum(extractNumberAry);
        outputView.printCalculateResult(calculator.getTotal());
    }

    private int[] extractNumbers(String input) {
        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        return toPositiveNumberArray(input.split(delimiter));
    }

    private int[] toPositiveNumberArray(String[] extractNumbers) {
        int[] numberArray = new int[extractNumbers.length];
        for (int count = 0; count < extractNumbers.length; count++) {
            numberArray[count] = verifyPositive(extractNumbers[count]);
        }

        return numberArray;
    }

    private int verifyPositive(String extractNumber) {
        return Integer.parseInt(extractNumber);
    }
}
