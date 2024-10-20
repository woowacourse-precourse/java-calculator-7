package calculator;

import calculator.controller.StringCalculatorController;

public class Application {
    public static void main(String[] args) {
        StringCalculatorController stringCalculatorController = new StringCalculatorController();
        stringCalculatorController.run();
    }
}
