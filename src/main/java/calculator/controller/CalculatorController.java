package calculator.controller;

import calculator.model.CalculationString;
import calculator.model.Calculator;
import calculator.model.StringHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final Calculator calculator;
    private final InputView inputView;
    private final OutputView outputView;
    private final StringHandler stringHandler;

    public CalculatorController(Calculator calculator, InputView inputView, OutputView outputView,
                                StringHandler stringHandler) {
        this.calculator = calculator;
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringHandler = stringHandler;
    }

    public void runCalculator() {
        CalculationString calculationString = readInput();
        int[] parsedNumbers = parseInput(calculationString);
        String result = calculateResult(parsedNumbers);
        printResult(result);
    }

    private CalculationString readInput() {
        return inputView.readInput();
    }

    private int[] parseInput(CalculationString calculationString) {
        return stringHandler.parseString(calculationString);
    }

    private String calculateResult(int[] intArray) {
        return calculator.calculate(intArray);
    }

    private void printResult(String result) {
        outputView.printResult(result);
    }
}
