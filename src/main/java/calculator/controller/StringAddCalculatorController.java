package calculator.controller;

import calculator.service.CalculatorService;
import calculator.validation.InputValidator;
import calculator.view.CalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class StringAddCalculatorController {

    private final CalculatorService calculatorService;
    private final InputValidator inputValidator;

    private static final int INVALID_RESULT = 0;

    public StringAddCalculatorController(CalculatorService calculatorService, InputValidator inputValidator) {
        this.calculatorService = calculatorService;
        this.inputValidator = inputValidator;
    }

    public void playCalculator() {
        String input = getInput();

        if (inputValidator.isInvalidInput(input)) {
            CalculatorView.outputView(INVALID_RESULT);
            return;
        }
        CalculatorView.outputView(calculatorService.calculateSum(input));
    }

    private String getInput() {
        CalculatorView.inputView();
        return Console.readLine();
    }

}