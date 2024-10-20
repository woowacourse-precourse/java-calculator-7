package calculator;

import calculator.controller.Calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.start();
        calculator.process();
        calculator.display();
    }
}
