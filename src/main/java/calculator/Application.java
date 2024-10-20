package calculator;

import calculator.service.Calculator;

public class Application {

    public static void main(String[] args) {

        Calculator calculator = Calculator.getCalculator();
        calculator.calculate();
    }
}
