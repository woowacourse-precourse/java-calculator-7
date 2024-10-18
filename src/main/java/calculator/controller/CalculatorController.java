package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.UserInput;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final Delimiter delimiter;
    private final UserInput userInput;
    private final CalculatorService service;

    public CalculatorController() {
        this.delimiter = new Delimiter();
        this.userInput = new UserInput();
        this.service = new CalculatorService();
    }

    public void run() {
        userInput.setUserInput(InputView.inputUserString());

        if (service.hasCustomDelimiter(userInput.getUserInput())) {
            service.handleCustomDelimiter(userInput.getUserInput());
            delimiter.addDelimiter(service.getCustomDelimiter());
            userInput.setUserInput(service.getPureExpression());
        }

        service.calculateSum(userInput.getUserInput(), delimiter.getDelimiter());
        int sum = service.getSum();

        OutputView.printResult(sum);
    }
}
