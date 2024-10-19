package calculator;

import calculator.util.CalculatorUtil;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        CalculatorConfig calculatorConfig = new CalculatorConfig();
        CalculatorController calculator = new CalculatorController(
                calculatorConfig.calculatorService(), calculatorConfig.view(), calculatorConfig.inputValidator());

        calculator.executeCalculation();
    }
}

