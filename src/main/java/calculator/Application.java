package calculator;

import calculator.config.CalculatorConfig;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {

        CalculatorConfig calculatorConfig = new CalculatorConfig();
        CalculatorController calculator = new CalculatorController(
                calculatorConfig.calculatorService(), calculatorConfig.view(), calculatorConfig.inputValidator());

        calculator.executeCalculation();
    }
}

