package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputViewBean = new InputView();
        final CalculatorController calculatorControllerBean = new CalculatorController(inputViewBean);

        calculatorControllerBean.run();
    }
}
