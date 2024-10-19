package calculator;

import calculator.controller.StringAddCalculatorController;
import calculator.service.StringAddCalculatorService;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.ConsoleInputView;
import calculator.view.OutputView;
import calculator.view.StandardOutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new StandardOutputView();

        InputValidator inputValidator = new InputValidator();

        StringAddCalculatorService stringAddCalculatorService = new StringAddCalculatorService(inputValidator);
        StringAddCalculatorController stringAddCalculatorController = new StringAddCalculatorController(stringAddCalculatorService, inputValidator);

        String output = stringAddCalculatorController.getStringAdd(inputView.readLine());

        outputView.print(output);
    }
}
