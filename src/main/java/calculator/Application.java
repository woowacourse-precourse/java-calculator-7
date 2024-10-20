package calculator;

import calculator.controller.Calculator;

public class Application {
    public static void main(String[] args) {
        Calculator controller = new Calculator();

        controller.start();
        controller.process();
        controller.display();
    }
}
