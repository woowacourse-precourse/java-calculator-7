package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CalculatorService stringTokenService = new CalculatorService(inputView);
        CalculatorController calculatorController = new CalculatorController(stringTokenService);

        calculatorController.run();
    }
}
