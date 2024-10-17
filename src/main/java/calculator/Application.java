package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.validate.CalculatorValidate;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        CalculatorValidate calculatorValidate = new CalculatorValidate();
        InputView inputView = new InputView(calculatorValidate);
        CalculatorService stringTokenService = new CalculatorService(inputView);
        CalculatorController calculatorController = new CalculatorController(stringTokenService);

        calculatorController.run();
    }
}
