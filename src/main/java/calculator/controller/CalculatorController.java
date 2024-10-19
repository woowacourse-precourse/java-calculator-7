package calculator.controller;

import calculator.model.AdditionOperator;
import calculator.model.MultiDelimiter;
import calculator.model.Operator;
import calculator.view.InputView;

import java.util.Arrays;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final MultiDelimiter splitDelimiter = new MultiDelimiter();
    private final Operator additionOperator = new AdditionOperator();

    public void run() {
        String userInput = inputView.receiveUserInput();
        String[] operand = splitDelimiter.splitWithDelimiter(userInput);
        int[] numbs = strToInt(operand);
        int res = additionOperator.calculate(numbs);
    }

    private int[] strToInt(String[] str) {
        return Arrays.stream(str)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
