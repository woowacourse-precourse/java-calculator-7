package calculator;

import calculator.controller.StringCalculatorController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculatorController stringCalculatorController = StringCalculatorController.createController();
        stringCalculatorController.run();
    }
}
