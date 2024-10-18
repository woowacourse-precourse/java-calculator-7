package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputViewBean = new InputView();
        final CalculatorService calculatorService = new CalculatorService();

        final CalculatorController calculatorControllerBean = new CalculatorController(
                inputViewBean,
                calculatorService
        );

        calculatorControllerBean.run();
    }
}
