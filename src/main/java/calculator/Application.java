package calculator;

import calculator.controller.Calculator;
import calculator.service.calculator.CalculatorService;
import calculator.service.separator.SeparatorService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator(
                new SeparatorService(),
                new CalculatorService()
        );

        calculator.run();
    }
}
