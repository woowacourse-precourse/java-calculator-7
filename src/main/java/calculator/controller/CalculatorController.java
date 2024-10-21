package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.inform();
        String input = inputView.input();

        if (input.isBlank()) {
            outputView.result(0L);
            return;
        }

        NumberConverter numberConverter = new NumberConverter();
        StringParser stringParser = new StringParser();
        CustomDelimiterValidator customDelimiterValidator = new CustomDelimiterValidator();
        InputValueValidator inputValueValidator = new InputValueValidator();

        Calculator calculator = new Calculator(numberConverter, stringParser, customDelimiterValidator,
                inputValueValidator);

        calculator.initialize(input);
        calculator.extractNumber();
        Long sum = calculator.sum();

        outputView.result(sum);
    }
}
