package calculator;

import calculator.common.di.IntegerCalculatorDependencyRegistry;
import calculator.common.di.NumberCalculatorDependencyRegistry;
import calculator.controller.NumberCalculatorController;

public class Application {

    public static void main(String[] args) {
        NumberCalculatorDependencyRegistry numberCalculatorDependencyRegistry =
                new IntegerCalculatorDependencyRegistry();

        NumberCalculatorController numberCalculatorController = new NumberCalculatorController(numberCalculatorDependencyRegistry);
        numberCalculatorController.run();
    }
}
