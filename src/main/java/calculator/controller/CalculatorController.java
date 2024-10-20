package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Delimiters;
import calculator.domain.InputParser;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    private final InputParser inputParser = new InputParser(new Delimiters());

    public void run(){
        String input = InputView.getInput();

        List<Double> numbers = inputParser.parse(input);
        Calculator calculator = new Calculator(numbers);
        double result = calculator.plus();

        OutputView.printResult(result);
    }
}
