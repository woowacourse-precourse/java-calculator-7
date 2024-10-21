package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.CalculatorFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculatorController = CalculatorFactory.createController();
        calculatorController.run();
    }
}
