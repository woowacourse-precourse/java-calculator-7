package calculator;

import controller.Calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.start();
        calculator.end();
    }
}
