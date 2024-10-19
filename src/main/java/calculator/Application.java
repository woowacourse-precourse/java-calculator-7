package calculator;

import calculator.businessLogic.Calculator;

public class Application {

    public static void main(String[] args) {

        Calculator calculator = Calculator.of();
        calculator.calculate();
    }
}
