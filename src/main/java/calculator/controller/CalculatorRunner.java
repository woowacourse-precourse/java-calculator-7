package calculator.controller;

import calculator.domain.calculator.Calculator;
import calculator.domain.calculator.StringAddCalculator;
import calculator.domain.delimiter.Delimiters;
import calculator.domain.input.InputParser;
import calculator.ui.InputView;
import calculator.ui.OutputView;

public class CalculatorRunner {

    public void run() {
        final StringAddCalculator stringAddCalculator = new StringAddCalculator(
                new InputParser(new Delimiters()),
                new Calculator()
        );

        final InputView inputView = new InputView();

        final String input = inputView.input();

        final int result = stringAddCalculator.splitAndSum(input);

        final OutputView outputView = new OutputView();

        outputView.output(result);
    }
}
