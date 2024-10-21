package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Validator;
import calculator.view.ConsoleView;

// 필요한 로직을 호출하고 실행
public class CalculatorController {
    private final Calculator calculator;
    private final ConsoleView consoleView;
    private final Validator validator;

    public CalculatorController(Calculator calculator, Validator validator, ConsoleView consoleView) {
        this.calculator = calculator;
        this.consoleView = consoleView;
        this.validator = validator;
    }

    public void run() {
        String input = consoleView.getInput();
        String delimiter = validator.getDelimiter(input);
        String userInput = validator.getValidInput(input);
        System.out.println("userInput:" + userInput);
        System.out.println("delimiter:" + delimiter);
        int result = calculator.calculate(userInput, delimiter);
        consoleView.showOutput(result);
    }
}
