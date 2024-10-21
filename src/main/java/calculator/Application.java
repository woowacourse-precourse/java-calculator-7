package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.SumCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Calculator calculator = new SumCalculator();
        CalculatorController controller = new CalculatorController(calculator);
        controller.run();
    }
}
