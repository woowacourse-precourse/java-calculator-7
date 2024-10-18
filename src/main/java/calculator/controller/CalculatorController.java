package calculator.controller;

import calculator.model.Calculator;
import calculator.util.refine.SeparatePositiveNumber;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final SeparatePositiveNumber separatePositiveNumber;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(SeparatePositiveNumber separatePositiveNumber, InputView inputView, OutputView outputView) {
        this.separatePositiveNumber = separatePositiveNumber;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startCalculate() {
        Calculator calculator = inputExpression();
        calculator.sum();
        printCalculateResult(calculator);
    }

    private Calculator inputExpression() {
        String expression = inputView.inputExpressionString();
        List<Integer> numberList = separatePositiveNumber.extractNumbers(expression);

        return new Calculator(numberList);
    }

    private void printCalculateResult(Calculator calculator) {
        outputView.printCalculateResult(calculator.getResult());
    }
}
