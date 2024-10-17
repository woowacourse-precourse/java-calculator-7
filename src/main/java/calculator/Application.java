package calculator;

import calculator.controller.InputController;
import calculator.service.CalculatorService;
import calculator.view.ConsoleView;

public class Application {

    public static void main(String[] args) {
        String input = InputController.getInput();

        CalculatorService calculatorService = new CalculatorService();

        if (input.startsWith("//")) {
            InputController.addCustomDelimiter(input);
        }

        calculatorService.validate(input);
        calculatorService.calculate(input);

        ConsoleView.showResult(calculatorService.getResult());
        calculatorService.resetResult();
    }
}
