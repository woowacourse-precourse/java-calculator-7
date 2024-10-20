package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            CalculatorController calculatorController = new CalculatorController();
            calculatorController.start();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }

}
