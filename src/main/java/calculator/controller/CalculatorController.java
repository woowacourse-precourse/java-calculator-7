package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.InputParser;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    private final InputParser calculatorParser = new InputParser();

    public void run(){
        String input = InputView.getInput();

        List<Double> operands = calculatorParser.parse(input);

        Calculator calculator = new Calculator(operands);
        double result = calculator.plus();

        OutputView.printResult(result);
    }
}
