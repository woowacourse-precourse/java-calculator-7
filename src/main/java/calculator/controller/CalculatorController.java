package calculator.controller;

import calculator.model.StringCalculator;
import calculator.validator.StringCalculatorValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final StringCalculatorValidator validator;
    private final StringCalculator model;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, StringCalculatorValidator validator, StringCalculator model,
                                OutputView outputView) {
        this.inputView = inputView;
        this.validator = validator;
        this.model = model;
        this.outputView = outputView;
    }

    public void run() {

        inputView.print();
        String userInput;
        userInput = inputView.getUserInput();

        validator.check(userInput);

        int result;
        result = model.calculate(userInput);

        outputView.print(result);
    }
}
