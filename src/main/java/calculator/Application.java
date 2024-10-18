package calculator;

import calculator.common.config.IntegerCalculatorDependencyRegistry;
import calculator.common.config.NumberCalculatorDependencyRegistry;
import calculator.controller.CalculatorController;

public class Application {


    public static void main(String[] args) {
        NumberCalculatorDependencyRegistry numberCalculatorDependencyRegistry =
                IntegerCalculatorDependencyRegistry.getInstance();

        CalculatorController calculatorController = new CalculatorController(numberCalculatorDependencyRegistry);
        calculatorController.run();
    }
}
