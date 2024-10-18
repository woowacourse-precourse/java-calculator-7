package calculator;

import calculator.common.config.IntegerCalculatorDependencyRegistry;
import calculator.common.config.NumberCalculatorDependencyRegistry;
import calculator.controller.NumberCalculatorController;

public class Application {

    public static void main(String[] args) {
        NumberCalculatorDependencyRegistry numberCalculatorDependencyRegistry =
                IntegerCalculatorDependencyRegistry.getInstance();

        NumberCalculatorController numberCalculatorController = new NumberCalculatorController(numberCalculatorDependencyRegistry);
        numberCalculatorController.run();
    }
}
