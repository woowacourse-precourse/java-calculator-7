package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.validate.CalculatorValidate;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorValidate calculatorValidate = new CalculatorValidate();
        InputView inputView = new InputView(calculatorValidate);
        OutputView outputView = new OutputView();
        CalculatorService stringTokenService = new CalculatorService(inputView, outputView);
        CalculatorController calculatorController = new CalculatorController(stringTokenService);

        calculatorController.run();
    }
}
