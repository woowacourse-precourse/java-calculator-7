package calculator;

import calculator.service.CalculatorStarter;

public class Application {
    public static void main(String[] args) {
        final CalculatorStarter calculatorStarter = new CalculatorStarter();
        calculatorStarter.calculate();
    }
}
