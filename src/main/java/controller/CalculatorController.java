package controller;

import domain.Calculator;
import domain.Separator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CalculatorController {
    private final Calculator calculator;
    private final Separator separator;

    public CalculatorController(Separator separator) {
        this.separator = separator;
        this.calculator = new Calculator(separator);
    }

    public void run() {
        String input = InputView.inputString();
        separator.findAndAddSeparator(input);
        List<Integer> numbers = separator.extractionNumbers(input);
        calculator.addNumber(numbers);
        OutputView.printResult(calculator);
    }
}
