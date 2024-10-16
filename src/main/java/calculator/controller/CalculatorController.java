package calculator.controller;

import calculator.model.Calculator;
import calculator.utils.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    private final InputView inputView;
    private final Calculator calculator;
    private final Parser parser;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, Calculator calculator, Parser parser, OutputView outputView) {
        this.inputView = inputView;
        this.calculator = calculator;
        this.parser = parser;
        this.outputView = outputView;
    }

    public void run() {
        String userInput = inputView.getInputString();

        List<Number> numbers = parser.parse(userInput);

        Number result = calculator.add(numbers);

        outputView.displayResult(result);
    }
}
