package calculator;

import calculator.config.CalculatorConfig;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorConfig config = new CalculatorConfig();
        CalculatorController controller = config.calculatorController();
        controller.calculate();
    }
}