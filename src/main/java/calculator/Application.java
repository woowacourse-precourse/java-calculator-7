package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        InputView view = new InputView();
        CalculatorController controller = new CalculatorController(calculator, view);

        controller.run();
    }
}
