package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputViewBean = new InputView();
        final OutputView outputViewBean = new OutputView();
        final CalculatorService calculatorService = new CalculatorService();

        final CalculatorController calculatorControllerBean = new CalculatorController(
                inputViewBean,
                outputViewBean,
                calculatorService
        );

        try {
            calculatorControllerBean.run();
        } catch (IllegalArgumentException e) {
            outputViewBean.errorPage(e.getMessage());
            throw e;
        }
    }
}
